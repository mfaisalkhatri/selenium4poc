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

/**
 * Created By Faisal Khatri on 24-12-2021
 */
public class FormAuthenticationPage {

    private final DriverManager driverManager;

    public FormAuthenticationPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    private WebElement userNameField () {
        return driverManager.getDriver().findElement(By.id("username"));
    }

    private WebElement passwordField () {
        return driverManager.getDriver().findElement(By.id("password"));
    }

    private WebElement loginBtn () {
        return driverManager.getDriver().findElement(By.cssSelector("#login > button"));
    }

    public String getFlashMessage () {
        return driverManager.getDriver().findElement(By.id("flash")).getText();
    }

    public SecurePage login (String userName, String password) {
        userNameField().click();
        userNameField().clear();
        userNameField().sendKeys(userName);
        passwordField().click();
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
        return new SecurePage(driverManager);
    }
}