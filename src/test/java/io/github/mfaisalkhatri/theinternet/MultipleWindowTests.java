package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleWindowTests extends Setup {

    private MultipleWindowsPage multipleWindowPage;

    @BeforeClass
    public void testSetup() {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Multiple Windows");
        multipleWindowPage = new MultipleWindowsPage(driver);
    }

    @Test
    public void testMultipleWindows() throws InterruptedException {
        multipleWindowPage.openLinkInNewWindow("Click Here");
        Assert.assertTrue(multipleWindowPage.checkNewWindowTitle("New Window"));
    }


}
