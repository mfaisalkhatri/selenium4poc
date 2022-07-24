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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 18-12-2021
 */
public class JSAlertPage {

    private final WebDriver driver;
    private WebDriverWait wait;
    private Alert alert;

    public JSAlertPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement jsAlertButton () {
        return driver.findElement(By.cssSelector("ul > li:nth-child(1) > button"));
    }

    public WebElement jsConfirmButton () {
        return driver.findElement(By.cssSelector("ul > li:nth-child(2) > button"));
    }

    public WebElement jspromptButton () {
        return driver.findElement(By.cssSelector("ul > li:nth-child(3) > button"));
    }

    public void checkForAlert () {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
    }

    public void acceptAlert () {
        alert.accept();
    }

    public void dismissAlert () {
        alert.dismiss();
    }

    public String getAlertText () {
        return alert.getText();
    }

    public void typeTextInAlert (String text) {
        alert.sendKeys(text);
    }

    public String resultText () {
        return driver.findElement(By.id("result")).getText();
    }
}