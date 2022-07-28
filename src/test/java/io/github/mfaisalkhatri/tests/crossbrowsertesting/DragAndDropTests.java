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
package io.github.mfaisalkhatri.tests.crossbrowsertesting;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import io.github.mfaisalkhatri.pages.crossbrowsertesting.DragAndDropPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 30-12-2021
 */
public class DragAndDropTests extends BaseSuiteSetup {

    @BeforeClass
    public void setupTest () {
        final String website = "https://crossbrowsertesting.github.io/drag-and-drop.html";
        getDriver ().get (website);
    }

    @Test
    public void testDragAndDrop () {
        final DragAndDropPage dragAndDropPage = new DragAndDropPage ();
        dragAndDropPage.dragAndDropBox ();
        Assert.assertEquals (dragAndDropPage.getDroppableBoxText (), "Dropped!");
    }
}