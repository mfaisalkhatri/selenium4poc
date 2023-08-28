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


import io.github.mfaisalkhatri.pages.theinternet.DragAndDropPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class DragAndDropTests extends BaseSuiteSetup {

    private DragAndDropPage dragAndDropPage;

    @BeforeClass
    public void setupTests () {
        final String website = "http://the-internet.herokuapp.com/";
        getDriver().get(website);
        final MainPage mainPage = new MainPage();
        mainPage.clickLink("Drag and Drop");
        this.dragAndDropPage = new DragAndDropPage();
    }

    @Test
    public void dragAndDropBoxAToB () {
        this.dragAndDropPage.dragBoxADropInBoxB();
        assertEquals(this.dragAndDropPage.getHeaderOfBoxA(), "B");
        assertEquals(this.dragAndDropPage.getHeaderOfBoxB(), "A");
    }

    @Test
    public void dragAndDropBoxBToA () {
        this.dragAndDropPage.dragBoxBDropInBoxA();
        assertEquals(this.dragAndDropPage.getHeaderOfBoxA(), "A");
        assertEquals(this.dragAndDropPage.getHeaderOfBoxB(), "B");
    }
}