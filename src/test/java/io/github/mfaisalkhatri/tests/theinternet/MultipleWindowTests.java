package io.github.mfaisalkhatri.tests.theinternet;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.pages.theinternet.MultipleWindowsPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 1812/2021
 */

public class MultipleWindowTests extends BaseSuiteSetup {

    @Test
    public void testMultipleWindows () {
        final MultipleWindowsPage multipleWindowPage = new MultipleWindowsPage ();
        multipleWindowPage.openLinkInNewWindow ("Click Here");
        assertTrue (multipleWindowPage.checkNewWindowTitle ("New Window"));
    }

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "https://the-internet.herokuapp.com/";
        getDriver ().get (websiteLink);
        final MainPage mainPage = new MainPage ();
        mainPage.clickLink ("Multiple Windows");
    }
}