package io.github.mfaisalkhatri.tests.lambdatestseleniumplayground;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.pages.lambdatestseleniumplayground.DropdownPage;
import io.github.mfaisalkhatri.pages.lambdatestseleniumplayground.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 11/16/2022
 **/
public class MultiSelectListTests extends BaseSuiteSetup {

    private DropdownPage dropdownPage;

    @BeforeClass
    public void setupTests () {
        final String website = "https://www.lambdatest.com/selenium-playground/";
        getDriver ().get (website);
        final MainPage mainPage = new MainPage ();
        mainPage.clickLink ("Select Dropdown List");
        this.dropdownPage = new DropdownPage ();
    }

    @Test
    public void testBySelectingMultipleValues () {
        this.dropdownPage.multiSelectByValues (new String[] { "California", "Ohio", "Texas", "Pennsylvania" });
        assertEquals (this.dropdownPage.getAllSelectedOptions (),
            this.dropdownPage.expectedValues (new String[] { "California", "Ohio", "Texas", "Pennsylvania" }));

    }

    @Test
    public void testBySelectingMultipleValuesByIndex () {
        this.dropdownPage.selectMultipleOptionByIndex (new int[] { 0, 2, 3 });
        assertEquals (this.dropdownPage.getAllSelectedOptions (),
            this.dropdownPage.expectedValues (new String[] { "California", "New Jersey", "New York" }));

    }

    @Test
    public void testBySelectingMultipleValuesByVisibleText () {
        this.dropdownPage.selectMultipleOptionByVisibleText (new String[] { "New York", "New Jersey", "Washington" });
        assertEquals (this.dropdownPage.getAllSelectedOptions (),
            this.dropdownPage.expectedValues (new String[] { "New Jersey", "New York", "Washington" }));

    }

    @Test
    public void testCheckIfDropdownIsMultiSelect () {
        assertTrue (this.dropdownPage.checkIfMultipleDropdown ());
    }
}

