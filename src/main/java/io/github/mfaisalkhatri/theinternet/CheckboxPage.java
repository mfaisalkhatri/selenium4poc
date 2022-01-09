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

import java.util.List;

/**
 * Created By Faisal Khatri on 21-12-2021
 */
class CheckboxPage {

    private final WebDriver driver;

    CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    String pageHeader() {
        return driver.findElement(By.tagName("h3")).getText();
    }

    private List<WebElement> checkboxes() {
        return driver.findElements(By.cssSelector("#checkboxes > input[type=checkbox]"));

    }

    WebElement checkboxOne() {
        return checkboxes().get(0);
    }

    WebElement checkboxTwo() {
        return checkboxes().get(1);
    }
}