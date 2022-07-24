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

import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.theinternet.ABTestingPage;
import io.github.mfaisalkhatri.theinternet.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class BrowserTests extends Setup {

    private static final String websiteLink = "http://the-internet.herokuapp.com/";

    public static String getWebsiteLink () {
        return websiteLink;
    }

    @BeforeClass
    public void testSetup () {
        getDriver().get(websiteLink);
    }

    @Test
    public void checkTitleAndWebsiteUrlTest () {
        final String title = "The Internet";
        String actualWebsiteLink = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        assertEquals(actualWebsiteLink, websiteLink);
        assertEquals(actualTitle, title);

    }

    @Test
    public void browserNavigationTests () {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickLink("Challenging DOM");
        ABTestingPage abTestingPage = new ABTestingPage(getDriver());
        String abTestingPageHeader = abTestingPage.pageHeader();
        assertEquals(abTestingPageHeader, "Challenging DOM");

        getDriver().navigate().back();
        String mainPageHeader = mainPage.mainPageHeader();
        assertEquals(mainPageHeader, "Available Examples");

        getDriver().navigate().forward();
        assertEquals(abTestingPageHeader, "Challenging DOM");

        getDriver().navigate().refresh();
        assertEquals(abTestingPageHeader, "Challenging DOM");
    }


}