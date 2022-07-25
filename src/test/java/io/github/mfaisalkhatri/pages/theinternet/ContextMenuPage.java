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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 22-12-2021
 */
public class ContextMenuPage {

    private final DriverManager driverManager;
    private WebDriverWait wait;
    private Alert alert;
    private Actions actions;

    public ContextMenuPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10));
        actions = new Actions(driverManager.getDriver());
    }

    private WebElement box () {
        return driverManager.getDriver().findElement(By.id("hot-spot"));
    }

    public void checkForAlert () {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driverManager.getDriver().switchTo().alert();
    }

    public String getAlertText () {
        return alert.getText();
    }

    public void rightClick () {
        actions.contextClick(box()).perform();
    }
}