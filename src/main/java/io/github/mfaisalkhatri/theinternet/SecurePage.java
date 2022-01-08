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
 * Created By Faisal Khatri on 24-12-2021
 */
class SecurePage {

    private final WebDriver driver;

    SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement logoutBtn() {
        return driver.findElement(By.linkText("Logout"));
    }

    String getFlashMessage() {
        return driver.findElement(By.id("flash")).getText();
    }

    String getHeaderText() {
        return driver.findElement(By.tagName("h2")).getText();
    }

    String getSubHeaderText() {
        return driver.findElement(By.tagName("h4")).getText();
    }

}