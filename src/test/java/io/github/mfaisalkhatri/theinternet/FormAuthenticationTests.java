package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 24-12-2021
 */
public class FormAuthenticationTests extends Setup {

    private FormAuthenticationPage formAuthenticationPage;
    private SecurePage securePage;
    private static final String userName = "tomsmith";
    private static final String password = "SuperSecretPassword!";

    @BeforeClass
    public void testSetup () {
        String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Form Authentication");
        formAuthenticationPage = new FormAuthenticationPage(driver);
        securePage = new SecurePage(driver);
    }

    @Test
    public void loginWithCorrectCredentials () {
        formAuthenticationPage.login(userName, password);
        Assert.assertTrue(securePage.getFlashMessage().contains("You logged into a secure area!"));
        Assert.assertEquals(securePage.getHeaderText(), "Secure Area");
        Assert.assertEquals(securePage.getSubHeaderText(), "Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertTrue(securePage.logoutBtn().isDisplayed());
    }

    @Test
    public void logOutTest () {
        securePage.logoutBtn().click();
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("You logged out of the secure area!"));
    }

    @Test
    public void userNameNotValidTest () {
        formAuthenticationPage.login(" ", password);
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your username is invalid!"));
    }

    @Test
    public void passwordNotValidTest () {
        formAuthenticationPage.login(userName, " ");
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your password is invalid!"));
    }

    @Test
    public void invalidLoginCredentialsTest () {
        formAuthenticationPage.login("tomsmith", "SuperSecret");
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your password is invalid!"));
    }

    @Test
    public void blankUserAndPasswordTest () {
        formAuthenticationPage.login(" ", " ");
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your username is invalid!"));
    }
}