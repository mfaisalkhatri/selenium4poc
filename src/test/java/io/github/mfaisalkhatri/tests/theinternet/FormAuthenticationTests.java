/*      Copyright 2022 Mohammad Faisal Khatri

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package io.github.mfaisalkhatri.tests.theinternet;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.github.mfaisalkhatri.pages.theinternet.FormAuthenticationPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.pages.theinternet.SecurePage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 24-12-2021
 */
public class FormAuthenticationTests extends BaseSuiteSetup {

    private static final String                 PASSWORD = "SuperSecretPassword!";
    private static final String                 USERNAME = "tomsmith";
    private              FormAuthenticationPage formAuthenticationPage;
    private              SecurePage             securePage;

    @Test
    public void blankUserAndPasswordTest () {
        this.formAuthenticationPage.login (" ", " ");
        assertTrue (this.formAuthenticationPage.getFlashMessage ()
            .contains ("Your username is invalid!"));
    }

    @Test
    public void invalidLoginCredentialsTest () {
        this.formAuthenticationPage.login (USERNAME, "InvalidPass");
        assertTrue (this.formAuthenticationPage.getFlashMessage ()
            .contains ("Your password is invalid!"));
    }

    @Test
    public void logOutTest () {
        this.securePage.logoutBtn ()
            .click ();
        assertTrue (this.formAuthenticationPage.getFlashMessage ()
            .contains ("You logged out of the secure area!"));
    }

    @DataProvider
    public Iterator<Object[]> loginData () {
        List<Object[]> testData = new ArrayList<> ();
        testData.add (new Object[] { " ", PASSWORD, false });
        testData.add (new Object[] { USERNAME, " ", false });
        testData.add (new Object[] { " ", " ", false });
        testData.add (new Object[] { USERNAME, "invalid", false });
        testData.add (new Object[] { USERNAME, PASSWORD, true });
        return testData.iterator ();
    }

    @Test (dataProvider = "loginData")
    public void loginTests (String userName, String password, boolean isValid) {
        this.formAuthenticationPage.login (userName, password);

        if (!isValid) {
            assertTrue (this.formAuthenticationPage.getFlashMessage ()
                .contains (" is invalid!"));
        } else {
            assertTrue (this.securePage.getFlashMessage ()
                .contains ("You logged into a secure area!"));
            assertEquals (this.securePage.getHeaderText (), "Secure Area");
            assertEquals (this.securePage.getSubHeaderText (),
                "Welcome to the Secure Area. When you are done click logout below.");
            assertTrue (this.securePage.logoutBtn ()
                .isDisplayed ());
            this.securePage.logoutBtn ()
                .click ();
            assertTrue (this.formAuthenticationPage.getFlashMessage ()
                .contains ("You logged out of the secure area!"));
        }
    }

    @Test
    public void loginWithCorrectCredentials () {
        this.formAuthenticationPage.login (USERNAME, PASSWORD);
        assertTrue (this.securePage.getFlashMessage ()
            .contains ("You logged into a secure area!"));
        assertEquals (this.securePage.getHeaderText (), "Secure Area");
        assertEquals (this.securePage.getSubHeaderText (),
            "Welcome to the Secure Area. When you are done click logout below.");
        assertTrue (this.securePage.logoutBtn ()
            .isDisplayed ());
    }

    @Test
    public void passwordNotValidTest () {
        this.formAuthenticationPage.login (USERNAME, " ");
        assertTrue (this.formAuthenticationPage.getFlashMessage ()
            .contains ("Your password is invalid!"));
    }

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver ().get (websiteLink);
        MainPage mainPage = new MainPage ();
        mainPage.clickLink ("Form Authentication");
        this.formAuthenticationPage = new FormAuthenticationPage ();
        this.securePage = new SecurePage ();
    }

    @Test
    public void userNameNotValidTest () {
        this.formAuthenticationPage.login (" ", PASSWORD);
        assertTrue (this.formAuthenticationPage.getFlashMessage ()
            .contains ("Your username is invalid!"));
    }
}