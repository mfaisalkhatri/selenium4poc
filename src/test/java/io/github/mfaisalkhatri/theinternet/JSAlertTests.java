package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 18-12-2021
 */
public class JSAlertTests extends Setup {

    private String websiteLink = "http://the-internet.herokuapp.com/";

    private void openJSAlertMenu () {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("JavaScript Alerts");
    }

    @Test
    public void alertTest () {
        openJSAlertMenu();
        JSAlertPage jsalPage = new JSAlertPage(driver);
        jsalPage.jsAlertButton().click();
        jsalPage.checkForAlert();
        String alertText = jsalPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        jsalPage.acceptAlert();
        Assert.assertEquals(jsalPage.resultText(), "You successfully clicked an alert");
    }

    @Test
    public void confirmAlertTest () {
        openJSAlertMenu();
        JSAlertPage jsAlertPage = new JSAlertPage(driver);
        jsAlertPage.jsConfirmButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        jsAlertPage.acceptAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You clicked: Ok");
    }

    @Test
    public void dismissAlertTest () {
        openJSAlertMenu();
        JSAlertPage jsAlertPage = new JSAlertPage(driver);
        jsAlertPage.jsConfirmButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        jsAlertPage.dismissAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You clicked: Cancel");
    }

    @Test
    public void jsPromptTypeAndAcceptTest () {
        openJSAlertMenu();
        JSAlertPage jsAlertPage = new JSAlertPage(driver);
        jsAlertPage.jspromptButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS prompt");
        String text = "Testing by typing text in JS Alert";
        jsAlertPage.typeTextInAlert(text);
        jsAlertPage.acceptAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You entered: " +text);
    }

    @Test
    public void jsPromptDismissTest () {
        openJSAlertMenu();
        JSAlertPage jsAlertPage = new JSAlertPage(driver);
        jsAlertPage.jspromptButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS prompt");
        jsAlertPage.dismissAlert();
        Assert.assertEquals(jsAlertPage.resultText(), "You entered: null");
    }
}