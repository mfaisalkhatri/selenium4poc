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

package io.github.mfaisalkhatri.pages.saucedemo;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class LoginPage {

    private final DriverManager driverManager;

    public LoginPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    private WebElement username () {
        return driverManager.getDriver().findElement(By.id("user-name"));
    }

    private WebElement password () {
        return driverManager.getDriver().findElement(with(By.tagName("input")).below(username()));

    }

    private WebElement loginBtn () {
        return driverManager.getDriver().findElement(with(By.tagName("input")).below(password()));
    }

    public void websiteLogin (String userName, String pswd) {
        username().click();
        username().clear();
        username().sendKeys(userName);
        password().click();
        password().clear();
        password().sendKeys(pswd);
        loginBtn().click();

    }

}