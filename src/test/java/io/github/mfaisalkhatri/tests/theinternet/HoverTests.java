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
import io.github.mfaisalkhatri.theinternet.HoverPage;
import io.github.mfaisalkhatri.theinternet.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class HoverTests extends Setup {
    
    private MainPage mainPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        mainPage = new MainPage(getDriver());
        mainPage.clickLink("Hovers");

    }

    @Test
    public void mouseHoverTests () {
        HoverPage hoverPage = new HoverPage(getDriver());
        hoverPage.hoverOnImage(hoverPage.imageOne());
        assertEquals(hoverPage.getImageOneName(), "name: user1");

        hoverPage.hoverOnImage(hoverPage.imageTwo());
        assertEquals(hoverPage.getImageTwoName(), "name: user2");

        hoverPage.hoverOnImage(hoverPage.imageThree());
        assertEquals(hoverPage.getImageThreeName(), "name: user3");
    }
}