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

    @BeforeClass
    public void testSetup () {
        String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Hovers");
        hoverPage = new HoverPage(driver);
    }

    @Test
    public void mouseHoverTests () {
        hoverPage.hoverOnImage(hoverPage.imageOne());
        Assert.assertEquals(hoverPage.getImageName(), "name: user1");

        hoverPage.hoverOnImage(hoverPage.imageTwo());
        Assert.assertEquals(hoverPage.getImageName(), "name: user2");

        hoverPage.hoverOnImage(hoverPage.imageThree());
        Assert.assertEquals(hoverPage.getImageName(), "name: user3");
    }
}