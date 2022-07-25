package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.pages.theinternet.MultipleWindowsPage;
import io.github.mfaisalkhatri.tests.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MultipleWindowTests extends BaseTest {

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driverManager.getDriver().get(websiteLink);
        MainPage mainPage = new MainPage(driverManager);
        mainPage.clickLink("Multiple Windows");
    }

    @Test
    public void testMultipleWindows () throws InterruptedException {
        MultipleWindowsPage multipleWindowPage = new MultipleWindowsPage(driverManager);
        multipleWindowPage.openLinkInNewWindow("Click Here");
        assertTrue(multipleWindowPage.checkNewWindowTitle("New Window"));
    }


}