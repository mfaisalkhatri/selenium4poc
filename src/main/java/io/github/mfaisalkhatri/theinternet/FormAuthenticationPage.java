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
class FormAuthenticationPage {

    private final WebDriver driver;

    FormAuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement userNameField() {
        return driver.findElement(By.id("username"));
    }

    private WebElement passwordField() {
        return driver.findElement(By.id("password"));
    }

    private WebElement loginBtn() {
        return driver.findElement(By.cssSelector("#login > button"));
    }

    String getFlashMessage() {
        return driver.findElement(By.id("flash")).getText();
    }

    SecurePage login(String userName, String password) {
        userNameField().click();
        userNameField().clear();
        userNameField().sendKeys(userName);
        passwordField().click();
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
        return new SecurePage(driver);
    }
}