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

import io.github.mfaisalkhatri.pages.theinternet.ContextMenuPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 22-12-2021
 */
public class RightClickTests extends BaseTest {

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driverManager.getDriver().get(websiteLink);
        MainPage mpage = new MainPage(driverManager);
        mpage.clickLink("Context Menu");
    }

    @Test
    public void testRightClick () {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driverManager);
        contextMenuPage.rightClick();
        contextMenuPage.checkForAlert();
        assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
    }
}