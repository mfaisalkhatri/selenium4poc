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

package io.github.mfaisalkhatri.pages.theinternet;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class DragAndDropPage {

    private final DriverManager driverManager;
    private final Actions action;

    public DragAndDropPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        action = new Actions(driverManager.getDriver());
    }

    private WebElement boxA () {
        return driverManager.getDriver().findElement(By.id("column-a"));
    }

    private WebElement boxB () {
        return driverManager.getDriver().findElement(By.id("column-b"));
    }

    public String getHeaderOfBoxA () {
        WebElement header = driverManager.getDriver().findElement(By.cssSelector("#column-a > header"));
        return header.getText();
    }

    public String getHeaderOfBoxB () {
        WebElement header = driverManager.getDriver().findElement(By.cssSelector("#column-b > header"));
        return header.getText();
    }

    public void dragBoxADropInBoxB () {
        action.dragAndDrop(boxA(), boxB()).build().perform();
    }

    public void dragBoxBDropInBoxA () {
        action.dragAndDrop(boxB(), boxA()).build().perform();
    }
}