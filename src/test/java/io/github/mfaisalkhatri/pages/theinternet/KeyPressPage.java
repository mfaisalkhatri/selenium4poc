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

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressPage {

    private final WebDriver driver;

    public KeyPressPage (WebDriver driver) {
        this.driver = driver;
    }

    private WebElement textBox () {
        return driver.findElement(By.id("target"));
    }

    private WebElement result () {
        return driver.findElement(By.id("result"));
    }

    public void pressKeys (Keys keys) {
        textBox().sendKeys(keys);
    }

    public String resultText () {
        return result().getText();
    }
}