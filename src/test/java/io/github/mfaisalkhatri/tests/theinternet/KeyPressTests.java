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

import io.github.mfaisalkhatri.pages.theinternet.KeyPressPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * @author Faisal Khatri
 * @since 1812/2021
 */

public class KeyPressTests extends BaseSuiteSetup {

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mainPage = new MainPage();
        mainPage.clickLink("Key Presses");
    }

    @Test
    public void keyPressTest () {
        KeyPressPage keyPressPage = new KeyPressPage();
        keyPressPage.pressKeys(Keys.ARROW_DOWN);
        assertEquals(keyPressPage.resultText(), "You entered: DOWN");
        keyPressPage.pressKeys(Keys.F3);
        assertEquals(keyPressPage.resultText(), "You entered: F3");
        keyPressPage.pressKeys(Keys.ALT);
        assertEquals(keyPressPage.resultText(), "You entered: ALT");
        keyPressPage.pressKeys(Keys.CONTROL);
        assertEquals(keyPressPage.resultText(), "You entered: CONTROL");
        keyPressPage.pressKeys(Keys.SPACE);
        assertEquals(keyPressPage.resultText(), "You entered: SPACE");
        keyPressPage.pressKeys(Keys.LEFT_SHIFT);
        assertEquals(keyPressPage.resultText(), "You entered: SHIFT");
    }
}