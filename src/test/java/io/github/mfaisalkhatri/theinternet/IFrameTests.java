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
 * Created By Faisal Khatri on 02-01-2022
 */
public class IFrameTests extends Setup {

    private IFramePage iframe;

    @BeforeClass
    public void setupTests () {
        final String website = "http://the-internet.herokuapp.com/";
        getDriver().get(website);
        MainPage mpage = new MainPage(getDriver());
        mpage.clickLink("Frames");
        mpage.clickLink("iFrame");
        iframe = new IFramePage(getDriver());
    }

    @Test
    public void testIFrame () {
        iframe.switchToiFrame();
        final String text = "Hello 123, entering value in iFrame!!";
        iframe.enterTextInIFrame(text);
        Assert.assertEquals(iframe.getTextValue(), text);
    }


}