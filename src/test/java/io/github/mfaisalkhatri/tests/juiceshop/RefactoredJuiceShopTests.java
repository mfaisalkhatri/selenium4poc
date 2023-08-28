package io.github.mfaisalkhatri.tests.juiceshop;

import io.github.mfaisalkhatri.data.juiceshop.UserData;
import io.github.mfaisalkhatri.pages.juiceshop.*;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.data.juiceshop.UserDataBuilder.getUserData;
import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class RefactoredJuiceShopTests extends BaseSuiteSetup {
    private String appleJuicePrice;
    private String appleJuiceText;
    private String bananaJuicePrice;
    private String bananaJuiceText;
    private MainPage mainPage;
    private ProductPage productPage;
    private UserData userData;

    @BeforeClass
    public void setupTests() {
        final String globalWebsiteLink = "https://juice-shop.herokuapp.com/#/";
        //final String dockerWebsiteLink = "http://host.docker.internal:3000/#/";
        final String websiteLink = "http://localhost:3000/#/";
        if (getDriver().toString().contains("RemoteWebDriver")) {
            getDriver().get(globalWebsiteLink);
        } else {
            getDriver().get(websiteLink);
        }
        this.mainPage = new MainPage();
        this.productPage = new ProductPage();
        this.userData = getUserData();
    }

    @Test(dependsOnMethods = "testLogin")
    public void testAddProductToCart() {
        this.productPage.addAppleJuiceToCart();
        assertEquals(this.productPage.successMessage(), "Placed Apple Juice (1000ml) into basket.");
        this.productPage.addBananaJuiceToCart();
        assertEquals(this.productPage.successMessage(), "Placed Banana Juice (1000ml) into basket.");
        assertEquals(this.mainPage.yourBasketCount(), "2");
        this.appleJuiceText = this.productPage.getAppleJuiceText();
        this.appleJuicePrice = this.productPage.getAppleJuicePrice();
        this.bananaJuiceText = this.productPage.getBananaJuiceText();
        this.bananaJuicePrice = this.productPage.getBananaJuicePrice();
    }

    @Test
    public void testLogin() {
        final var loginPage = new LoginPage();
        loginPage.loginIntoJuiceShop(this.userData.getEmail(), this.userData.getPass());
        this.mainPage.accountLink()
                .click();
        assertTrue(loginPage.logOutLink()
                .isDisplayed());
    }

    @Test(dependsOnMethods = "testSelectDelivery")
    public void testMakePayment() {
        final PaymentPage paymentPage = new PaymentPage();
        paymentPage.makePayment(this.userData.getName(), "4012888888881881", "2", "2080");
    }

    @Test(dependsOnMethods = "testOrderSummary")
    public void testOrderConfirmation() {
        final OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
        assertEquals(orderConfirmationPage.getThanksMessage(), "Thank you for your purchase!");
        assertEquals(orderConfirmationPage.getOrderConfirmationMessage(),
                "Your order has been placed and is being processed. You can check for status updates on our Track Orders page.");
        assertEquals(orderConfirmationPage.getOrderDeliveryMessage(), "Your order will be delivered in 1 days.");
        assertEquals(this.mainPage.yourBasketCount(), "0");
    }

    @Test(dependsOnMethods = "testMakePayment")
    public void testOrderSummary() {
        final OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
        final String addressLineTwo = this.userData.getAddress() + ", " + this.userData.getCity() + ", " + this.userData.getState() + ", " + this.userData.getZipcode();
        assertEquals(orderSummaryPage.getDeliveryAddressCustomerName(), this.userData.getName());
        assertEquals(orderSummaryPage.getDeliveryAddress(), addressLineTwo);
        assertEquals(orderSummaryPage.getDeliveryAddressCountry(), this.userData.getCountry());
        assertEquals(orderSummaryPage.getDeliveryAddressPhoneNumber(), "Phone Number " + this.userData.getMobileNumber());
        assertEquals(orderSummaryPage.getPaymentmethodCardEnding(), "Card ending in 1881");
        assertEquals(orderSummaryPage.getPaymentmethodCardHolderName(), "Card Holder " + this.userData.getName());
        assertEquals(orderSummaryPage.getItemsPrice(), "3.98¤");
        assertEquals(orderSummaryPage.getDeliveryAmount(), "0.99¤");
        assertEquals(orderSummaryPage.getTotalPrice(), "4.97¤");
        assertEquals(orderSummaryPage.getAppleJuiceText(), this.appleJuiceText);
        assertEquals(orderSummaryPage.getAppleJuiceQty(), "1");
        assertEquals(orderSummaryPage.getAppleJuicePrice(), this.appleJuicePrice);
        assertEquals(orderSummaryPage.getBananaJuiceText(), this.bananaJuiceText);
        assertEquals(orderSummaryPage.getBananaJuiceQty(), "1");
        assertEquals(orderSummaryPage.getBananaJuicePrice(), this.bananaJuicePrice);
        orderSummaryPage.placeOrderAndPay();
    }

    @Test(dependsOnMethods = "testAddProductToCart")
    public void testProductCheckout() {
        this.productPage.navigateToYourBasket();
        final CheckoutPage checkoutPage = new CheckoutPage();

        assertEquals(checkoutPage.appleJuiceText(), this.appleJuiceText);
        assertEquals(checkoutPage.appleJuiceQty(), "1");
        assertEquals(checkoutPage.appleJuicePrice(), this.appleJuicePrice);
        assertEquals(checkoutPage.bananaJuiceText(), this.bananaJuiceText);
        assertEquals(checkoutPage.bananaJuiceQty(), "1");
        assertEquals(checkoutPage.bananaJuicePrice(), this.bananaJuicePrice);
        assertEquals(checkoutPage.totalPrice(), "Total Price: 3.98¤");
        checkoutPage.checkoutProduct();
        checkoutPage.addAddressForDelivery(this.userData.getCountry(), this.userData.getName(), this.userData.getMobileNumber(), this.userData.getZipcode(), this.userData.getAddress(),
                this.userData.getCity(), this.userData.getState());

    }

    @Test
    public void testRegisterUser() {
        final RegistrationPage registrationPage = new RegistrationPage();
        this.mainPage.openLoginPage();
        registrationPage.registerUser(this.userData.getEmail(), this.userData.getPass(), "Mother's maiden name?", "Jane Doe");
        assertEquals(registrationPage.successMessage(), "Registration completed successfully. You can now log in.");
    }

    @Test(dependsOnMethods = "testProductCheckout")
    public void testSelectDelivery() {
        final DeliverySelection deliverySelection = new DeliverySelection();
        final String addressLineTwo = this.userData.getAddress() + ", " + this.userData.getCity() + ", " + this.userData.getState() + ", " + this.userData
                .getZipcode();
        assertEquals(deliverySelection.getDeliveryAddressName(), this.userData.getName());
        assertEquals(deliverySelection.getDeliveryAddress(), addressLineTwo);
        assertEquals(deliverySelection.getDeliveryAddressCountry(), this.userData.getCountry());
        assertEquals(deliverySelection.getDeliveryAddressPhoneNumber(), "Phone Number " + this.userData.getMobileNumber());
        deliverySelection.selectDeliveryOption();
    }
}
