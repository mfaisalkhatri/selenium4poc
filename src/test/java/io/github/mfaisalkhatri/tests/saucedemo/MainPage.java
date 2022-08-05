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

package io.github.mfaisalkhatri.tests.saucedemo;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class MainPage {
    
    private final WebDriverWait wait;

    public MainPage () {
        this.wait = new WebDriverWait (getDriver (), Duration.ofSeconds (5));
    }

    public void logoutFromWebSite () {
        menuBtn ().click ();
        logoutLink ().click ();
    }

    private WebElement logoutLink () {
        return this.wait.until (ExpectedConditions.elementToBeClickable ((By.cssSelector ("#logout_sidebar_link"))));
    }

    private WebElement menuBtn () {
        return this.wait.until (ExpectedConditions.elementToBeClickable (By.id ("react-burger-menu-btn")));
    }
}