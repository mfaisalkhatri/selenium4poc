package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class BrowserTests extends Setup {


    private String websiteLink = "http://the-internet.herokuapp.com/";

    @BeforeClass
    public void testSetup () {
        driver.get(websiteLink);
    }

    @Test
    public void checkTitleAndWebsiteUrlTest () {
        String title = "The Internet";
        String actualWebsiteLink = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualWebsiteLink, websiteLink);
        Assert.assertEquals(actualTitle, title);

    }

    @Test
    public void browserNavigationTests () {
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("A/B Testing");
        ABTestingPage abTestingPage = new ABTestingPage(driver);
        String abTestingPageHeader = abTestingPage.pageHeader();
        Assert.assertEquals(abTestingPageHeader, "A/B Test Control");

        driver.navigate().back();
        String mainPageHeader = mpage.mainPageHeader();
        Assert.assertEquals(mainPageHeader, "Available Examples");

        driver.navigate().forward();
        Assert.assertEquals(abTestingPageHeader, "A/B Test Control");

        driver.navigate().refresh();
        Assert.assertEquals(abTestingPageHeader, "A/B Test Control");
    }


}