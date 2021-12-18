package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 18-12-2021
 */
public class JSAlertTests extends Setup {

    private String websiteLink = "http://the-internet.herokuapp.com/";

    @Test
    public void alertTest() {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("JavaScript Alerts");
        JSAlertPage jsalPage = new JSAlertPage(driver);
        jsalPage.jsAlertButton().click();
        jsalPage.checkForAlert();
        String alertText = jsalPage.getAlertText();
        Assert.assertEquals(alertText,"I am a JS Alert");
        jsalPage.acceptAlert();
    }
}