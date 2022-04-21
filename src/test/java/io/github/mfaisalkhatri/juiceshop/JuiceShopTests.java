package io.github.mfaisalkhatri.juiceshop;

import com.github.javafaker.Faker;
import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.juiceshop.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JuiceShopTests extends Setup {

    private Faker faker;
    private String email;
    private String pass;
    private String appleJuiceText;
    private String appleJuicePrice;
    private String bananaJuiceText;
    private String bananaJuicePrice;
    private String country;
    private String name;
    private int mobileNumber;
    private String zipcode;
    private String address;
    private String city;
    private String state;
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private DeliverySelection deliverySelection;
    private PaymentPage paymentPage;
    private OrderSummaryPage orderSummaryPage;
    private OrderConfirmationPage orderConfirmationPage;


    @BeforeClass
    public void setupTests () {
        // final String websiteLink = "https://juice-shop.herokuapp.com/#/";it
        final String websiteLink = "http://localhost:3000";
        getDriver().get(websiteLink);
        mainPage = new MainPage(getDriver());
        registrationPage = new RegistrationPage(getDriver());
        loginPage = new LoginPage(getDriver());
        productPage = new ProductPage(getDriver());
        checkoutPage = new CheckoutPage(getDriver());
        deliverySelection = new DeliverySelection(getDriver());
        paymentPage = new PaymentPage(getDriver());
        orderSummaryPage = new OrderSummaryPage(getDriver());
        orderConfirmationPage = new OrderConfirmationPage(getDriver());
        faker = Faker.instance();
        email = faker.internet().emailAddress();
        pass = faker.internet().password(6, 12);
        country = faker.address().country();
        name = faker.name().fullName();
        mobileNumber = faker.number().numberBetween(99900000, 99988888);
        zipcode = faker.number().digits(6);
        address = faker.address().streetAddress();
        city = faker.address().city();
        state = faker.address().state();
    }

    @Test
    public void registerUserTest () {
        mainPage.openLoginPage();
        registrationPage.registerUser(email, pass, "Mother's maiden name?", "Jane Doe");
        assertEquals(registrationPage.successMessage(), "Registration completed successfully. You can now log in.");

    }

    @Test
    public void loginTest () {
        loginPage.loginIntoJuiceShop(email, pass);
        mainPage.accountLink().click();
        assertTrue(loginPage.logOutLink().isDisplayed());
    }

    @Test(dependsOnMethods = "loginTest")
    public void addProductToCartTest () {
        productPage.addAppleJuiceToCart();
        assertEquals(productPage.successMessage(), "Placed Apple Juice (1000ml) into basket.");
        productPage.addBananaJuiceToCart();
        assertEquals(productPage.successMessage(), "Placed Banana Juice (1000ml) into basket.");
        assertEquals(mainPage.yourBasketCount(), "2");
        appleJuiceText = productPage.getAppleJuiceText();
        appleJuicePrice = productPage.getAppleJuicePrice();
        bananaJuiceText = productPage.getBananaJuiceText();
        bananaJuicePrice = productPage.getBananaJuicePrice();
    }

    @Test(dependsOnMethods = "addProductToCartTest")
    public void productCheckoutTest () {
        productPage.navigateToYourBasket();
        assertEquals(checkoutPage.appleJuiceText(), appleJuiceText);
        assertEquals(checkoutPage.appleJuiceQty(), "1");
        assertEquals(checkoutPage.appleJuicePrice(), appleJuicePrice);
        assertEquals(checkoutPage.bananaJuiceText(), bananaJuiceText);
        assertEquals(checkoutPage.bananaJuiceQty(), "1");
        assertEquals(checkoutPage.bananaJuicePrice(), bananaJuicePrice);
        assertEquals(checkoutPage.totalPrice(), "Total Price: 3.98¤");
        checkoutPage.checkoutProduct();
        checkoutPage.addAddressForDelivery(country, name, mobileNumber, zipcode, address, city, state);
    }

    @Test(dependsOnMethods = "productCheckoutTest")
    public void selectDeliveryTest () {
        String addressLineTwo = address + ", " + city + ", " + state + ", " + zipcode;
        assertEquals(deliverySelection.getDeliveryAddressName(), name);
        assertEquals(deliverySelection.getDeliveryAddress(), addressLineTwo);
        assertEquals(deliverySelection.getDeliveryAddressCountry(), country);
        assertEquals(deliverySelection.getDeliveryAddressPhoneNumber(), "Phone Number " + mobileNumber);
        deliverySelection.selectDeliveryOption();
    }

    @Test(dependsOnMethods = "selectDeliveryTest")
    public void makePaymentTest () {
        paymentPage.makePayment(name, "4012888888881881", "2", "2080");
    }

    @Test(dependsOnMethods = "makePaymentTest")
    public void orderSummaryTest () {
        String addressLineTwo = address + ", " + city + ", " + state + ", " + zipcode;
        assertEquals(orderSummaryPage.getDeliveryAddressCustomerName(), name);
        assertEquals(orderSummaryPage.getDeliveryAddress(), addressLineTwo);
        assertEquals(orderSummaryPage.getDeliveryAddressCountry(), country);
        assertEquals(orderSummaryPage.getDeliveryAddressPhoneNumber(), "Phone Number " + mobileNumber);
        assertEquals(orderSummaryPage.getPaymentmethodCardEnding(), "Card ending in 1881");
        assertEquals(orderSummaryPage.getPaymentmethodCardHolderName(), "Card Holder " + name);
        assertEquals(orderSummaryPage.getItemsPrice(), "3.98¤");
        assertEquals(orderSummaryPage.getDeliveryAmount(), "0.99¤");
        assertEquals(orderSummaryPage.getTotalPrice(), "4.97¤");
        assertEquals(orderSummaryPage.getAppleJuiceText(), appleJuiceText);
        assertEquals(orderSummaryPage.getAppleJuiceQty(), "1");
        assertEquals(orderSummaryPage.getAppleJuicePrice(), appleJuicePrice);
        assertEquals(orderSummaryPage.getBananaJuiceText(), bananaJuiceText);
        assertEquals(orderSummaryPage.getBananaJuiceQty(), "1");
        assertEquals(orderSummaryPage.getBananaJuicePrice(), bananaJuicePrice);
        orderSummaryPage.placeOrderAndPay();
    }

    @Test(dependsOnMethods = "orderSummaryTest")
    public void orderConfirmationTest () {
        assertEquals(orderConfirmationPage.getThanksMessage(), "Thank you for your purchase!");
        assertEquals(orderConfirmationPage.getOrderConfirmationMessage(), "Your order has been placed and is being processed. You can check for status updates on our Track Orders page.");
        assertEquals(orderConfirmationPage.getOrderDeliveryMessage(), "Your order will be delivered in 1 days.");
        assertEquals(mainPage.yourBasketCount(), "0");
    }
}