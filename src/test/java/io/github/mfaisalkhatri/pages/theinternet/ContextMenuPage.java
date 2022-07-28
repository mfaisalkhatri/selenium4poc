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

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created By Faisal Khatri on 22-12-2021
 */
public class ContextMenuPage {

    private Alert alert;

    public void checkForAlert () {
        final WebDriverWait wait = new WebDriverWait (getDriver (), Duration.ofSeconds (10));
        wait.until (ExpectedConditions.alertIsPresent ());
        this.alert = getDriver ().switchTo ()
            .alert ();
    }

    public String getAlertText () {
        return this.alert.getText ();
    }
    
    public void rightClick () {
        final Actions actions = new Actions (getDriver ());
        actions.contextClick (box ())
            .perform ();
    }

    private WebElement box () {
        return getDriver ().findElement (By.id ("hot-spot"));
    }
}