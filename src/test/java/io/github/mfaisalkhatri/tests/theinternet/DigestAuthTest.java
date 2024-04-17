package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

public class DigestAuthTest extends BaseSuiteSetup {

    @BeforeClass
    public void testSetup() {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        final MainPage mainPage = new MainPage();
        mainPage.clickLink("Basic Auth");
    }

    @Test
    public void testAuthentication() {
        getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        final String successMessageText = getDriver().findElement(By.cssSelector(".example p")).getText();
        assertEquals(successMessageText, "Congratulations! You must have the proper credentials.");
    }
}