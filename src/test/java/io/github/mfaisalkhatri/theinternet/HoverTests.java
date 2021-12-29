package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class HoverTests extends Setup {

    private HoverPage hoverPage;
    private MainPage mainPage;
    @BeforeClass
    public void testSetup () {
        String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        mainPage = new MainPage(driver);
        mainPage.clickLink("Hovers");
        hoverPage = new HoverPage(driver);
    }

    @Test
    public void mouseHoverTests () {
        hoverPage.hoverOnImage(hoverPage.imageOne());
        Assert.assertEquals(hoverPage.getImageOneName(), "name: user1");

        hoverPage.hoverOnImage(hoverPage.imageTwo());
        mainPage.takeScreenShot();
        Assert.assertEquals(hoverPage.getImageTwoName(), "name: user2");


        hoverPage.hoverOnImage(hoverPage.imageThree());
        Assert.assertEquals(hoverPage.getImageThreeName(), "name: user3");
    }
}