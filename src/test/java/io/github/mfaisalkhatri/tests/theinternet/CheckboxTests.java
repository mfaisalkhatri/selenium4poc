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

import io.github.mfaisalkhatri.pages.theinternet.CheckboxPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.*;

/**
 * Created By Faisal Khatri on 21-12-2021
 */
public class CheckboxTests extends BaseSuiteSetup {

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mainPage = new MainPage();
        mainPage.clickLink("Checkboxes");
    }

    @Test
    public void testCheckboxes () {
        CheckboxPage checkboxPage = new CheckboxPage();
        String pageHeader = checkboxPage.pageHeader();
        assertEquals(pageHeader, "Checkboxes");

        checkboxPage.checkboxOne().click();
        assertTrue(checkboxPage.checkboxOne().isSelected());

        assertTrue(checkboxPage.checkboxTwo().isSelected());

        checkboxPage.checkboxOne().click();
        assertFalse(checkboxPage.checkboxOne().isSelected());

        checkboxPage.checkboxTwo().click();
        assertFalse(checkboxPage.checkboxOne().isSelected());
    }
}