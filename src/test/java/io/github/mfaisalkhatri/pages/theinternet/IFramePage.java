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

/**
 * Created By Faisal Khatri on 02-01-2022
 */
public class IFramePage {
    
    public void enterTextInIFrame (final String text) {
        textArea ().click ();
        textArea ().clear ();
        textArea ().sendKeys (text);
    }

    public String getTextValue () {
        return getDriver ().findElement (By.cssSelector ("#tinymce > p"))
            .getText ();
    }

    public void switchToiFrame () {
        getDriver ().switchTo ()
            .frame (iFrame ());
    }

    private WebElement iFrame () {
        return getDriver ().findElement (By.id ("mce_0_ifr"));
    }

    private WebElement textArea () {
        return getDriver ().findElement (By.id ("tinymce"));
    }
}