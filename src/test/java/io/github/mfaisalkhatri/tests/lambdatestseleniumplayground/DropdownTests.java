package io.github.mfaisalkhatri.tests.lambdatestseleniumplayground;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import io.github.mfaisalkhatri.pages.lambdatestseleniumplayground.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 11/16/2022
 **/
public class DropdownTests extends BaseSuiteSetup {

    @BeforeClass
    public void setupTests () {
        final String website = "https://www.lambdatest.com/selenium-playground/";
        getDriver ().get (website);
        final MainPage mainPage = new MainPage ();
        mainPage.clickLink ("Select Dropdown List");
    }

    @Test
    public void testDropDown () {

    }

}
