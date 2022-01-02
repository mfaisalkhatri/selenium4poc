package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 02-01-2022
 */
public class IFrameTests extends Setup {

    IFramePage iframe;

    @BeforeClass
    public void setupTests () {
        String website = "http://the-internet.herokuapp.com/";
        driver.get(website);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Frames");
        mpage.clickLink("iFrame");
        iframe = new IFramePage(driver);
    }

    @Test
    public void testIFrame () {
        iframe.switchToiFrame();
        String text = "Hello 123, entering value in iFrame!!";
        iframe.enterTextInIFrame(text);
        Assert.assertEquals(iframe.getTextValue(), text);
    }


}