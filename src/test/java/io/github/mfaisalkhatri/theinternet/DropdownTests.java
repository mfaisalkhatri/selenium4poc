package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 20-12-2021
 */
public class DropdownTests extends Setup {

    private static final String websiteLink = "http://the-internet.herokuapp.com/";
    private DropdownPage dropdownPage;

    @BeforeClass
    public void testSetup () {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Dropdown");
        dropdownPage = new DropdownPage(driver);    }

    @Test
    public void selectByOptionTest () {
        String visibleText = "Option 1";
        dropdownPage.dropDownbox().selectByVisibleText("Option 1");
        Assert.assertEquals(dropdownPage.getSelectedOption(), visibleText);
    }

    @Test
    public void selectByIndexText () {
        dropdownPage.dropDownbox().selectByIndex(1);
        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }

    @Test
    public void selectByValueTest () {
        dropdownPage.dropDownbox().selectByValue("1");
        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }
}