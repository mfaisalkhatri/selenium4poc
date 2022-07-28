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

package io.github.mfaisalkhatri.pages.crossbrowsertesting;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 30-12-2021
 */
public class DragAndDropPage {

    public void dragAndDropBox () {
        final Actions actions = new Actions (getDriver ());
        actions.dragAndDrop (draggable (), droppable ())
            .build ()
            .perform ();
    }
    
    public String getDroppableBoxText () {
        return getDriver ().findElement (By.cssSelector ("#droppable > p"))
            .getText ();
    }

    private WebElement draggable () {
        return getDriver ().findElement (By.id ("draggable"));
    }

    private WebElement droppable () {
        return getDriver ().findElement (By.id ("droppable"));
    }

}