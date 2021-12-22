package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 22-12-2021
 */
public class RightClickTests extends Setup {

    private String websiteLink = "http://the-internet.herokuapp.com/";
    private ContextMenuPage contextMenuPage;

    @BeforeClass
    public void testSetup () {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Context Menu");
        contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void testRightClick() {
        contextMenuPage.rightClick();
        contextMenuPage.checkForAlert();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
    }



}