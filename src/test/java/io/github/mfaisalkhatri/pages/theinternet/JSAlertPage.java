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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

/**
 * Created By Faisal Khatri on 18-12-2021
 */
public class JSAlertPage {

    private final WebDriverWait wait;
    private Alert alert;

    public JSAlertPage () {
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public WebElement jsAlertButton () {
        return getDriver().findElement(By.cssSelector("ul > li:nth-child(1) > button"));
    }

    public WebElement jsConfirmButton () {
        return getDriver().findElement(By.cssSelector("ul > li:nth-child(2) > button"));
    }

    public WebElement jspromptButton () {
        return getDriver().findElement(By.cssSelector("ul > li:nth-child(3) > button"));
    }

    public void checkForAlert () {
        this.wait.until(ExpectedConditions.alertIsPresent());
        this.alert = getDriver().switchTo().alert();
    }

    public void acceptAlert () {
        this.alert.accept();
    }

    public void dismissAlert () {
        this.alert.dismiss();
    }

    public String getAlertText () {
        return this.alert.getText();
    }

    public void typeTextInAlert (final String text) {
        this.alert.sendKeys(text);
    }

    public String resultText () {
        return getDriver().findElement(By.id("result")).getText();
    }
}