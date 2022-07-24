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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 30-12-2021
 */
public class DragAndDropPage {

    private final WebDriver driver;

    public DragAndDropPage (WebDriver driver) {
        this.driver = driver;
    }

    private WebElement draggable () {
        return driver.findElement(By.id("draggable"));
    }

    private WebElement droppable () {
        return driver.findElement(By.id("droppable"));
    }

    public String getDroppableBoxText () {
        return driver.findElement(By.cssSelector("#droppable > p")).getText();

    }

    public void dragAndDropBox () {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable(), droppable()).build().perform();
    }

}