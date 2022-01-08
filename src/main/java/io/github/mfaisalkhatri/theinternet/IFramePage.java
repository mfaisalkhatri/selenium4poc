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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 02-01-2022
 */
class IFramePage {

    private final WebDriver driver;

    IFramePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement iFrame() {
        return driver.findElement(By.id("mce_0_ifr"));
    }

    void switchToiFrame() {
        driver.switchTo().frame(iFrame());
    }

    private WebElement textArea() {
        return driver.findElement(By.id("tinymce"));
    }

    String getTextValue() {
        return driver.findElement(By.cssSelector("#tinymce > p")).getText();
    }

    void enterTextInIFrame(String text) {
        textArea().click();
        textArea().clear();
        textArea().sendKeys(text);
    }
}