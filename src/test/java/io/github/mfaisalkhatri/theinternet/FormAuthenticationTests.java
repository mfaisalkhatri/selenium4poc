package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 24-12-2021
 */
public class FormAuthenticationTests extends Setup {

    private FormAuthenticationPage formAuthenticationPage;

    @BeforeClass
    public void testSetup () {
        String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Context Menu");
        formAuthenticationPage = new FormAuthenticationPage(driver);
    }

    @Test
    public void loginWithCorrectCredentials () {
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword!");
        formAuthenticationPage.flashMessage().getText()
    }
}