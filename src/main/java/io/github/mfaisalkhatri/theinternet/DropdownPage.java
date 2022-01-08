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
import org.openqa.selenium.support.ui.Select;

/**
 * Created By Faisal Khatri on 20-12-2021
 */
class DropdownPage {

    private final WebDriver driver;

    DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    Select dropDownbox() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        return new Select(dropdown);
    }

    String getSelectedOption() {
        return dropDownbox().getFirstSelectedOption().getText();
    }
}