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
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 20-12-2021
 */
public class DropdownTests extends Setup {

    private DropdownPage dropdownPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mpage = new MainPage(getDriver());
        mpage.clickLink("Dropdown");
        dropdownPage = new DropdownPage(getDriver());
    }

    @Test
    public void selectByOptionTest () {
        final String visibleText = "Option 1";
        dropdownPage.dropDownbox().selectByVisibleText("Option 1");
        Assert.assertEquals(dropdownPage.getSelectedOption(), visibleText);
    }

    @Test
    public void selectByIndexText () {
        dropdownPage.dropDownbox().selectByIndex(1);
        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }

    @Test
    public void selectByValueTest () {
        dropdownPage.dropDownbox().selectByValue("1");
        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
    }
}