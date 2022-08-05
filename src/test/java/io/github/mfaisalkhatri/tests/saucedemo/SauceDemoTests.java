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
package io.github.mfaisalkhatri.tests.saucedemo;

import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class SauceDemoTests extends BaseSuiteSetup {

    @BeforeClass
    public void setupTest () {
        final String website = "https://www.saucedemo.com";
        getDriver().navigate().to(website);
    }

    @Test
    public void loginSauceDemoTest () {
        LoginPage loginPage = new LoginPage();
        loginPage.websiteLogin("standard_user", "secret_sauce");
    }

    @Test
    public void logOutSauceDemoTest () {
        MainPage mainPage = new MainPage();
        mainPage.logoutFromWebSite();
    }
}