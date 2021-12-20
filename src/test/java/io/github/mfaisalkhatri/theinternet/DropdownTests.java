package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 20-12-2021
 */
public class DropdownTests extends Setup {

    private String websiteLink = "http://the-internet.herokuapp.com/";


    private void openDropDownPage () {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Dropdown");
    }

    @Test
    public void selectByOptionTest () {
        openDropDownPage();
        String visibleText = "Option 1";
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.dropDownbox().selectByVisibleText("Option 1");
        Assert.assertEquals(dropdownPage.getSelectedOption(), visibleText);
    }

    @Test
    public void selectByIndexText () {
        openDropDownPage();
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.dropDownbox().selectByIndex(1);
        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }

    @Test
    public void selectByValueTest () {
        openDropDownPage();
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.dropDownbox().selectByValue("1");
        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }
}