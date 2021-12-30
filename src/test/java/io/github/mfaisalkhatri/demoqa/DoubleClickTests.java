package io.github.mfaisalkhatri.demoqa;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 30-12-2021
 */
public class DoubleClickTests extends Setup {

    private ButtonsPage buttonsPage;


    @BeforeClass
    public void testSetup () {
        String webSite = "https://demoqa.com/buttons";
        driver.get(webSite);
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void testDoubleClick () {
        buttonsPage.doubleClickonButton();
        Assert.assertEquals(buttonsPage.getTextOnClick(), "You have done a double click");
    }

}