package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.pages.theinternet.MultipleWindowsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MultipleWindowTests extends Setup {

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickLink("Multiple Windows");
    }

    @Test
    public void testMultipleWindows () throws InterruptedException {
        MultipleWindowsPage multipleWindowPage = new MultipleWindowsPage(getDriver());
        multipleWindowPage.openLinkInNewWindow("Click Here");
        assertTrue(multipleWindowPage.checkNewWindowTitle("New Window"));
    }


}