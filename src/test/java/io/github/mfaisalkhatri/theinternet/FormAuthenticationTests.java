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
package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created By Faisal Khatri on 24-12-2021
 */
public class FormAuthenticationTests extends Setup {

    private static final String userName = "tomsmith";
    private static final String password = "SuperSecretPassword!";
    private FormAuthenticationPage formAuthenticationPage;
    private SecurePage securePage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Form Authentication");
        formAuthenticationPage = new FormAuthenticationPage(driver);
        securePage = new SecurePage(driver);
    }

    @Test
    public void loginWithCorrectCredentials () {
        formAuthenticationPage.login(userName, password);
        Assert.assertTrue(securePage.getFlashMessage().contains("You logged into a secure area!"));
        Assert.assertEquals(securePage.getHeaderText(), "Secure Area");
        Assert.assertEquals(securePage.getSubHeaderText(), "Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertTrue(securePage.logoutBtn().isDisplayed());
    }

    @Test
    public void logOutTest () {
        securePage.logoutBtn().click();
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("You logged out of the secure area!"));
    }

    @Test
    public void userNameNotValidTest () {
        formAuthenticationPage.login(" ", password);
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your username is invalid!"));
    }

    @Test
    public void passwordNotValidTest () {
        formAuthenticationPage.login(userName, " ");
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your password is invalid!"));
    }

    @Test
    public void invalidLoginCredentialsTest () {
        formAuthenticationPage.login("tomsmith", "SuperSecret");
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your password is invalid!"));
    }

    @Test
    public void blankUserAndPasswordTest () {
        formAuthenticationPage.login(" ", " ");
        Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("Your username is invalid!"));
    }

    @DataProvider
    public Iterator<Object[]> loginData () {
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[]{" ", password, false});
        testData.add(new Object[]{userName, " ", false});
        testData.add(new Object[]{" ", " ", false});
        testData.add(new Object[]{userName, "invalid", false});
        testData.add(new Object[]{userName, password, true});
        return testData.iterator();
    }


    @Test(dataProvider = "loginData")
    public void loginTests (String userName, String password, boolean isValid) {
        formAuthenticationPage.login(userName, password);

        if (!isValid) {
            Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains(" is invalid!"));
        } else {
            Assert.assertTrue(securePage.getFlashMessage().contains("You logged into a secure area!"));
            Assert.assertEquals(securePage.getHeaderText(), "Secure Area");
            Assert.assertEquals(securePage.getSubHeaderText(), "Welcome to the Secure Area. When you are done click logout below.");
            Assert.assertTrue(securePage.logoutBtn().isDisplayed());
            securePage.logoutBtn().click();
            Assert.assertTrue(formAuthenticationPage.getFlashMessage().contains("You logged out of the secure area!"));
        }
    }
}