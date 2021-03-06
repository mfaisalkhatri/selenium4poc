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
package io.github.mfaisalkhatri.saucedemo;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class SauceDemoTests extends Setup {

    @BeforeClass
    public void setupTest () {
        final String website = "https://www.saucedemo.com";
        getDriver().navigate().to(website);
    }

    @Test
    public void loginSauceDemoTest () {
        LoginPage lpage = new LoginPage(getDriver());
        lpage.websiteLogin("standard_user", "secret_sauce");
    }

    @Test
    public void logOutSauceDemoTest () {
        MainPage mpage = new MainPage(getDriver());
        mpage.logoutFromWebSite();
    }
}