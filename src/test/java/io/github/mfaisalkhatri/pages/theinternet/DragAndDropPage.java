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

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class DragAndDropPage {

    private final Actions action;

    public DragAndDropPage () {
        this.action = new Actions (getDriver ());
    }

    public void dragBoxADropInBoxB () {
        this.action.dragAndDrop (boxA (), boxB ())
            .build ()
            .perform ();
    }

    public void dragBoxBDropInBoxA () {
        this.action.dragAndDrop (boxB (), boxA ())
            .build ()
            .perform ();
    }

    public String getHeaderOfBoxA () {
        final WebElement header = getDriver ().findElement (By.cssSelector ("#column-a > header"));
        return header.getText ();
    }

    public String getHeaderOfBoxB () {
        final WebElement header = getDriver ().findElement (By.cssSelector ("#column-b > header"));
        return header.getText ();
    }

    private WebElement boxA () {
        return getDriver ().findElement (By.id ("column-a"));
    }

    private WebElement boxB () {
        return getDriver ().findElement (By.id ("column-b"));
    }
}