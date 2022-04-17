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
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private String appleJuiceText;
    private String appleJuicePrice;
    private String bananaJuiceText;
    private String bananaJuicePrice;


    @BeforeClass
    public void setupTests () {
        final String websiteLink = "https://juice-shop.herokuapp.com/#/";
        driver.get(websiteLink);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        faker = Faker.instance();
        email = faker.internet().emailAddress();
        pass = faker.name().firstName();
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
        final String email = "fk1@test.com";
        final String pass = "Pass123";
        loginPage.loginIntoJuiceShop(email, pass);
        mainPage.accountLink().click();
        assertTrue(loginPage.logOutLink().isDisplayed());
    }

    @Test
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

    @Test
    public void productCheckoutTests () {
        productPage.navigateToYourBasket();
        assertEquals(checkoutPage.appleJuiceText(), appleJuiceText);
        assertEquals(checkoutPage.appleJuiceQty(), "1");
        assertEquals(checkoutPage.appleJuicePrice(), appleJuicePrice);
        assertEquals(checkoutPage.bananaJuiceText(), bananaJuiceText);
        assertEquals(checkoutPage.bananaJuiceQty(), "1");
        assertEquals(checkoutPage.bananaJuicePrice(), bananaJuicePrice);
        assertEquals(checkoutPage.totalPrice(), "Total Price: 3.98¤");
        checkoutPage.checkoutProduct();
    }
}