package io.github.mfaisalkhatri.juiceshop;

import com.github.javafaker.Faker;
import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.juiceshop.pages.LoginPage;
import io.github.mfaisalkhatri.juiceshop.pages.MainPage;
import io.github.mfaisalkhatri.juiceshop.pages.RegistrationPage;
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

    @BeforeClass
    public void setupTests() {
        final String websiteLink = "http://localhost:3000";
        driver.get(websiteLink);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        faker = Faker.instance();
        email = faker.internet().emailAddress();
        pass = faker.name().firstName();
    }

    @Test
    public void registerUserTest() {
        mainPage.openLoginPage();
        registrationPage.registerUser(email, pass, "Mother's maiden name?", "Jane Doe");
        assertEquals(registrationPage.successMessage(), "Registration completed successfully. You can now log in.");

    }

    @Test
    public void loginTest() {
        loginPage.loginIntoJuiceShop(email, pass);
        mainPage.accountLink().click();
        assertTrue(loginPage.logOutLink().isDisplayed());
    }
}
