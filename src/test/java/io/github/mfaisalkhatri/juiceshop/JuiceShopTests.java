package io.github.mfaisalkhatri.juiceshop;

import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.juiceshop.pages.LoginPage;
import io.github.mfaisalkhatri.juiceshop.pages.MainPage;
import io.github.mfaisalkhatri.juiceshop.pages.RegistrationPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JuiceShopTests extends Setup {

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
    }

    @Test
    public void registerUserTest() {
        mainPage.openLoginPage();
        loginPage.notaCustomerLink().click();
        registrationPage.registerUser("abc@test.com", "Pass123", "Mother's maiden name?", "Jane Doe");
    }
}
