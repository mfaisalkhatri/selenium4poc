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

import io.github.mfaisalkhatri.pages.theinternet.ABTestingPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class BrowserTests extends BaseSuiteSetup {

    private static final String websiteLink = "http://the-internet.herokuapp.com/";

    @Test
    public void browserNavigationTests () {
        MainPage mainPage = new MainPage ();
        mainPage.clickLink ("Challenging DOM");
        ABTestingPage abTestingPage = new ABTestingPage ();
        String abTestingPageHeader = abTestingPage.pageHeader ();
        assertEquals (abTestingPageHeader, "Challenging DOM");

        getDriver ().navigate ()
            .back ();
        String mainPageHeader = mainPage.mainPageHeader ();
        assertEquals (mainPageHeader, "Available Examples");

        getDriver ().navigate ()
            .forward ();
        assertEquals (abTestingPageHeader, "Challenging DOM");

        getDriver ().navigate ()
            .refresh ();
        assertEquals (abTestingPageHeader, "Challenging DOM");
    }

    @Test
    public void checkTitleAndWebsiteUrlTest () {
        final String title = "The Internet";
        String actualWebsiteLink = getDriver ().getCurrentUrl ();
        String actualTitle = getDriver ().getTitle ();

        assertEquals (actualWebsiteLink, websiteLink);
        assertEquals (actualTitle, title);

    }

    @BeforeClass
    public void testSetup () {
        getDriver ().get (websiteLink);
    }

}