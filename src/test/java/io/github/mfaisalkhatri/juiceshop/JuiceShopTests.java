package io.github.mfaisalkhatri.juiceshop;

import com.github.javafaker.Faker;
import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.juiceshop.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JuiceShopTests extends Setup {

    Faker faker;
    private String email;
    private String pass;
    private String appleJuiceText;
    private String appleJuicePrice;
    private String bananaJuiceText;
    private String bananaJuicePrice;
    private String country;
    private String name;
    private String mobileNumber;
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


    @BeforeClass
    public void setupTests () {
        final String websiteLink = "https://juice-shop.herokuapp.com/#/";
        driver.get(websiteLink);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        deliverySelection = new DeliverySelection(driver);
        faker = Faker.instance();
        email = faker.internet().emailAddress();
        pass = faker.name().firstName();
        country = faker.address().country();
        name = faker.name().fullName();
        mobileNumber = faker.number().digits(10);
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
        mainPage.openLoginPage();
//        final String email = "fk1@test.com";
//        final String pass = "Pass123";
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
}