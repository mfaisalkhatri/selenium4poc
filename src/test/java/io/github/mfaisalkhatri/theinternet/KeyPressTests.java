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
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class KeyPressTests extends Setup {

    private KeyPressPage keyPressPage;

    @BeforeClass
    public void testSetup() {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Key Presses");
        keyPressPage = new KeyPressPage(driver);
    }

    @Test
    public void keyPressTest() {
        keyPressPage.pressKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(keyPressPage.resultText(), "You entered: DOWN");
        keyPressPage.pressKeys(Keys.F3);
        Assert.assertEquals(keyPressPage.resultText(), "You entered: F3");
        keyPressPage.pressKeys(Keys.ALT);
        Assert.assertEquals(keyPressPage.resultText(), "You entered: ALT");
        keyPressPage.pressKeys(Keys.CONTROL);
        Assert.assertEquals(keyPressPage.resultText(), "You entered: CONTROL");
        keyPressPage.pressKeys(Keys.SPACE);
        Assert.assertEquals(keyPressPage.resultText(), "You entered: SPACE");
        keyPressPage.pressKeys(Keys.LEFT_SHIFT);
        Assert.assertEquals(keyPressPage.resultText(), "You entered: SHIFT");
    }
}
