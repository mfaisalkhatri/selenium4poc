package io.github.mfaisalkhatri.tests.lambdatestseleniumplayground;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import io.github.mfaisalkhatri.pages.lambdatestseleniumplayground.DropdownPage;
import io.github.mfaisalkhatri.pages.lambdatestseleniumplayground.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 11/16/2022
 **/
public class SingleDropdownTests extends BaseSuiteSetup {

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
    public void testDropDownAllowsMultipleSelection () {
        assertFalse (this.dropdownPage.checkIfDropdownAllowsMultipleSelection ());
    }

    @Test
    public void testGetAllOptionsInDropdownField () {
        assertEquals (this.dropdownPage.getOptions (), this.dropdownPage.expectedValues (
            new String[] { "Please select", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday" }));
    }

    @Test
    public void testSelectDayUsingIndex () {
        this.dropdownPage.selectSingleDayIndex (2);
        assertEquals (this.dropdownPage.getSelectedDropDownText (), "Day selected :- Monday");
    }

    @Test
    public void testSelectDayUsingValue () {
        this.dropdownPage.selectSingleDayValue ("Friday");
        assertEquals (this.dropdownPage.getSelectedDropDownText (), "Day selected :- Friday");
    }

    @Test
    public void testSelectDayUsingVisibleText () {
        this.dropdownPage.selectDayByVisibleText ("Thursday");
        assertEquals (this.dropdownPage.getSelectedDropDownText (), "Day selected :- Thursday");
    }
}
