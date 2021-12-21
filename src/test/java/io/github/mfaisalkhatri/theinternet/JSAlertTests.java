package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 18-12-2021
 */
public class JSAlertTests extends Setup {

    private String websiteLink = "http://the-internet.herokuapp.com/";
    private JSAlertPage jsAlertPage;

    @BeforeClass
    private void setupTest () {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("JavaScript Alerts");
        jsAlertPage = new JSAlertPage(driver);
    }

    @Test
    public void alertTest () {
        jsAlertPage.jsAlertButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        jsAlertPage.acceptAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You successfully clicked an alert");
    }

    @Test
    public void confirmAlertTest () {
        jsAlertPage.jsConfirmButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        jsAlertPage.acceptAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You clicked: Ok");
    }

    @Test
    public void dismissAlertTest () {
        jsAlertPage.jsConfirmButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        jsAlertPage.dismissAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You clicked: Cancel");
    }

    @Test
    public void jsPromptTypeAndAcceptTest () {
        jsAlertPage.jspromptButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS prompt");
        String text = "Testing by typing text in JS Alert";
        jsAlertPage.typeTextInAlert(text);
        jsAlertPage.acceptAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You entered: " + text);
    }

    @Test
    public void jsPromptDismissTest () {
        jsAlertPage.jspromptButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS prompt");
        jsAlertPage.dismissAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You entered: null");
    }
}