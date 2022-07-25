package io.github.mfaisalkhatri.tests.lambdatestecommerce;

import io.github.mfaisalkhatri.pages.lambdatestecommerce.HomePage;
import io.github.mfaisalkhatri.pages.lambdatestecommerce.MyAccountPage;
import io.github.mfaisalkhatri.pages.lambdatestecommerce.RegistrationPage;
import io.github.mfaisalkhatri.pages.lambdatestecommerce.RegistrationSuccessPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class EndToEndWebsiteTests extends BaseSuiteSetup {

    @BeforeClass
    public void setupTests () {
        final String website = "https://ecommerce-playground.lambdatest.io/";
        driverManager.getDriver().get(website);
    }

    @Test
    public void testRegisterUser () {
        HomePage homePage = new HomePage(driverManager);
        homePage.openUserRegistrationPage();

        RegistrationPage registrationPage = new RegistrationPage(driverManager);
        assertEquals(registrationPage.pageHeader(), "Register Account");
        registrationPage.registerUser();

        RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage(driverManager);
        assertEquals(registrationSuccessPage.registrationSuccessfulMessage(), "Your Account Has Been Created!");

        registrationSuccessPage.continueToMyAccount();

        MyAccountPage myAccountPage = new MyAccountPage(driverManager);
        assertEquals(myAccountPage.pageHeader(), "My Account");
    }
}