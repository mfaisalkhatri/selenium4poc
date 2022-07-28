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

import io.github.mfaisalkhatri.pages.theinternet.DropdownPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 20-12-2021
 */
public class DropdownTests extends BaseSuiteSetup {

    private DropdownPage dropdownPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mainPage = new MainPage();
        mainPage.clickLink("Dropdown");
        dropdownPage = new DropdownPage();
    }

    @Test
    public void selectByOptionTest () {
        final String visibleText = "Option 1";
        dropdownPage.dropDownbox().selectByVisibleText("Option 1");
        assertEquals(dropdownPage.getSelectedOption(), visibleText);
    }

    @Test
    public void selectByIndexText () {
        dropdownPage.dropDownbox().selectByIndex(1);
        assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }

    @Test
    public void selectByValueTest () {
        dropdownPage.dropDownbox().selectByValue("1");
        assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }
}