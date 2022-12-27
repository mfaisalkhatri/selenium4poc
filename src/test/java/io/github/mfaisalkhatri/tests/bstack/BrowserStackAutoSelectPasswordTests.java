package io.github.mfaisalkhatri.tests.bstack;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import io.github.mfaisalkhatri.pages.bstack.LoginPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 12/27/2022
 **/
public class BrowserStackAutoSelectPasswordTests extends BaseSuiteSetup {

    @BeforeClass
    public void setupTest () {
        final String website = "https://www.bstackdemo.com/signin";
        getDriver ().get (website);
    }

    @Test
    public void testAutoSelectPasswordText () {

        LoginPage loginPage = new LoginPage ();
        loginPage.openPasswordDropdown ();
        loginPage.selectAutofillPasswordText ();
        System.out.println ("Password autoselected is: " + loginPage.getPasswordText ());
    }
}
