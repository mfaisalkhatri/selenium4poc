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

import io.github.mfaisalkhatri.pages.theinternet.ABTestingPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class BrowserTests extends BaseTest {

    private static final String websiteLink = "http://the-internet.herokuapp.com/";

    public static String getWebsiteLink () {
        return websiteLink;
    }

    @BeforeClass
    public void testSetup () {
        driverManager.getDriver().get(websiteLink);
    }

    @Test
    public void checkTitleAndWebsiteUrlTest () {
        final String title = "The Internet";
        String actualWebsiteLink = driverManager.getDriver().getCurrentUrl();
        String actualTitle = driverManager.getDriver().getTitle();

        assertEquals(actualWebsiteLink, websiteLink);
        assertEquals(actualTitle, title);

    }

    @Test
    public void browserNavigationTests () {
        MainPage mainPage = new MainPage(driverManager);
        mainPage.clickLink("Challenging DOM");
        ABTestingPage abTestingPage = new ABTestingPage(driverManager);
        String abTestingPageHeader = abTestingPage.pageHeader();
        assertEquals(abTestingPageHeader, "Challenging DOM");

        driverManager.getDriver().navigate().back();
        String mainPageHeader = mainPage.mainPageHeader();
        assertEquals(mainPageHeader, "Available Examples");

        driverManager.getDriver().navigate().forward();
        assertEquals(abTestingPageHeader, "Challenging DOM");

        driverManager.getDriver().navigate().refresh();
        assertEquals(abTestingPageHeader, "Challenging DOM");
    }


}