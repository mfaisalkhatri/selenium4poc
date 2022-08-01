package io.github.mfaisalkhatri.tests.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;
import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.pages.juiceshop.CheckoutPage;
import io.github.mfaisalkhatri.pages.juiceshop.DeliverySelection;
import io.github.mfaisalkhatri.pages.juiceshop.LoginPage;
import io.github.mfaisalkhatri.pages.juiceshop.MainPage;
import io.github.mfaisalkhatri.pages.juiceshop.OrderConfirmationPage;
import io.github.mfaisalkhatri.pages.juiceshop.OrderSummaryPage;
import io.github.mfaisalkhatri.pages.juiceshop.PaymentPage;
import io.github.mfaisalkhatri.pages.juiceshop.ProductPage;
import io.github.mfaisalkhatri.pages.juiceshop.RegistrationPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JuiceShopTests extends BaseSuiteSetup {

    private String      address;
    private String      appleJuicePrice;
    private String      appleJuiceText;
    private String      bananaJuicePrice;
    private String      bananaJuiceText;
    private String      city;
    private String      country;
    private String      email;
    private Faker       faker;
    private LoginPage   loginPage;
    private MainPage    mainPage;
    private int         mobileNumber;
    private String      name;
    private String      pass;
    private ProductPage productPage;
    private String      state;
    private String      zipcode;

    @BeforeClass
    public void setupTests () {
         final String globalWebsiteLink = "https://juice-shop.herokuapp.com/#/";
       //final String dockerWebsiteLink = "http://host.docker.internal:3000/#/";
        final String websiteLink = "http://localhost:3000/#/";
        System.out.println (getDriver ().toString ());
        if (getDriver ().toString ().contains ("RemoteWebDriver")) {
            getDriver ().get (globalWebsiteLink);
        } else {
            getDriver ().get (websiteLink);
        }
        this.mainPage = new MainPage ();
        this.loginPage = new LoginPage ();
        this.productPage = new ProductPage ();
        this.faker = Faker.instance ();
        this.email = this.faker.internet ()
            .emailAddress ();
        this.pass = this.faker.internet ()
            .password (6, 12);
        this.country = this.faker.address ()
            .country ();
        this.name = this.faker.name ()
            .fullName ();
        this.mobileNumber = this.faker.number ()
            .numberBetween (99900000, 99988888);
        this.zipcode = this.faker.number ()
            .digits (6);
        this.address = this.faker.address ()
            .streetAddress ();
        this.city = this.faker.address ()
            .city ();
        this.state = this.faker.address ()
            .state ();
    }

    @Test (dependsOnMethods = "testLogin")
    public void testAddProductToCart () {
        this.productPage.addAppleJuiceToCart ();
        assertEquals (this.productPage.successMessage (), "Placed Apple Juice (1000ml) into basket.");
        this.productPage.addBananaJuiceToCart ();
        assertEquals (this.productPage.successMessage (), "Placed Banana Juice (1000ml) into basket.");
        assertEquals (this.mainPage.yourBasketCount (), "2");
        this.appleJuiceText = this.productPage.getAppleJuiceText ();
        this.appleJuicePrice = this.productPage.getAppleJuicePrice ();
        this.bananaJuiceText = this.productPage.getBananaJuiceText ();
        this.bananaJuicePrice = this.productPage.getBananaJuicePrice ();
    }

    @Test
    public void testLogin () {
        this.loginPage.loginIntoJuiceShop (this.email, this.pass);
        this.mainPage.accountLink ()
            .click ();
        assertTrue (this.loginPage.logOutLink ()
            .isDisplayed ());
    }

    @Test (dependsOnMethods = "testSelectDelivery")
    public void testMakePayment () {
        final PaymentPage paymentPage = new PaymentPage ();
        paymentPage.makePayment (this.name, "4012888888881881", "2", "2080");
    }

    @Test (dependsOnMethods = "testOrderSummary")
    public void testOrderConfirmation () {
        final OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage ();
        assertEquals (orderConfirmationPage.getThanksMessage (), "Thank you for your purchase!");
        assertEquals (orderConfirmationPage.getOrderConfirmationMessage (),
            "Your order has been placed and is being processed. You can check for status updates on our Track Orders page.");
        assertEquals (orderConfirmationPage.getOrderDeliveryMessage (), "Your order will be delivered in 1 days.");
        assertEquals (this.mainPage.yourBasketCount (), "0");
    }

    @Test (dependsOnMethods = "testMakePayment")
    public void testOrderSummary () {
        final OrderSummaryPage orderSummaryPage = new OrderSummaryPage ();
        final String addressLineTwo = this.address + ", " + this.city + ", " + this.state + ", " + this.zipcode;
        assertEquals (orderSummaryPage.getDeliveryAddressCustomerName (), this.name);
        assertEquals (orderSummaryPage.getDeliveryAddress (), addressLineTwo);
        assertEquals (orderSummaryPage.getDeliveryAddressCountry (), this.country);
        assertEquals (orderSummaryPage.getDeliveryAddressPhoneNumber (), "Phone Number " + this.mobileNumber);
        assertEquals (orderSummaryPage.getPaymentmethodCardEnding (), "Card ending in 1881");
        assertEquals (orderSummaryPage.getPaymentmethodCardHolderName (), "Card Holder " + this.name);
        assertEquals (orderSummaryPage.getItemsPrice (), "3.98¤");
        assertEquals (orderSummaryPage.getDeliveryAmount (), "0.99¤");
        assertEquals (orderSummaryPage.getTotalPrice (), "4.97¤");
        assertEquals (orderSummaryPage.getAppleJuiceText (), this.appleJuiceText);
        assertEquals (orderSummaryPage.getAppleJuiceQty (), "1");
        assertEquals (orderSummaryPage.getAppleJuicePrice (), this.appleJuicePrice);
        assertEquals (orderSummaryPage.getBananaJuiceText (), this.bananaJuiceText);
        assertEquals (orderSummaryPage.getBananaJuiceQty (), "1");
        assertEquals (orderSummaryPage.getBananaJuicePrice (), this.bananaJuicePrice);
        orderSummaryPage.placeOrderAndPay ();
    }

    @Test (dependsOnMethods = "testAddProductToCart")
    public void testProductCheckout () {
        this.productPage.navigateToYourBasket ();
        final CheckoutPage checkoutPage = new CheckoutPage ();

        assertEquals (checkoutPage.appleJuiceText (), this.appleJuiceText);
        assertEquals (checkoutPage.appleJuiceQty (), "1");
        assertEquals (checkoutPage.appleJuicePrice (), this.appleJuicePrice);
        assertEquals (checkoutPage.bananaJuiceText (), this.bananaJuiceText);
        assertEquals (checkoutPage.bananaJuiceQty (), "1");
        assertEquals (checkoutPage.bananaJuicePrice (), this.bananaJuicePrice);
        assertEquals (checkoutPage.totalPrice (), "Total Price: 3.98¤");
        checkoutPage.checkoutProduct ();
        checkoutPage.addAddressForDelivery (this.country, this.name, this.mobileNumber, this.zipcode, this.address,
            this.city, this.state);
    }

    @Test
    public void testRegisterUser () {
        final RegistrationPage registrationPage = new RegistrationPage ();
        this.mainPage.openLoginPage ();
        registrationPage.registerUser (this.email, this.pass, "Mother's maiden name?", "Jane Doe");
        assertEquals (registrationPage.successMessage (), "Registration completed successfully. You can now log in.");
    }

    @Test (dependsOnMethods = "testProductCheckout")
    public void testSelectDelivery () {
        final DeliverySelection deliverySelection = new DeliverySelection ();
        final String addressLineTwo = this.address + ", " + this.city + ", " + this.state + ", " + this.zipcode;
        assertEquals (deliverySelection.getDeliveryAddressName (), this.name);
        assertEquals (deliverySelection.getDeliveryAddress (), addressLineTwo);
        assertEquals (deliverySelection.getDeliveryAddressCountry (), this.country);
        assertEquals (deliverySelection.getDeliveryAddressPhoneNumber (), "Phone Number " + this.mobileNumber);
        deliverySelection.selectDeliveryOption ();
    }
}