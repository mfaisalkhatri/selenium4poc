package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 21-12-2021
 */
public class CheckboxTests extends Setup {

    private String websiteLink = "http://the-internet.herokuapp.com/";
    private CheckboxPage checkboxPage;

    @BeforeClass
    public void testSetup () {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Checkboxes");
        checkboxPage = new CheckboxPage(driver);
    }

    @Test
    public void testCheckboxes () throws InterruptedException {
        String pageHeader = checkboxPage.pageHeader();
        Assert.assertEquals(pageHeader, "Checkboxes");

        checkboxPage.checkboxOne().click();
        Assert.assertTrue(checkboxPage.checkboxOne().isSelected());

        Assert.assertTrue(checkboxPage.checkboxTwo().isSelected());

        checkboxPage.checkboxOne().click();
        Assert.assertFalse(checkboxPage.checkboxOne().isSelected());

        checkboxPage.checkboxTwo().click();
        Assert.assertFalse(checkboxPage.checkboxOne().isSelected());


    }

}