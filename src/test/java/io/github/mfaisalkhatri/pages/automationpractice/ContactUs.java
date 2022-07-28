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

package io.github.mfaisalkhatri.pages.automationpractice;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class ContactUs {

    public void fillContactForm (final String subjectHeading, final String emailId, final String orderRef,
        final String message) {
        subjectHeading ().selectByVisibleText (subjectHeading);
        emailAddress ().click ();
        emailAddress ().clear ();
        emailAddress ().sendKeys (emailId);
        orderReference ().click ();
        orderReference ().clear ();
        orderReference ().sendKeys (orderRef);
        message ().click ();
        message ().clear ();
        message ().sendKeys (message);
        sendBtn ().click ();
    }

    public String pageHeading () {
        return getDriver ().findElement (By.tagName ("h1"))
            .getText ();
    }

    public String successSentMessage () {
        return getDriver ().findElement (By.cssSelector ("#center_column > p"))
            .getText ();
    }

    private WebElement attachFileLabel () {
        return getDriver ().findElement (By.cssSelector ("p:nth-child(7) > label"));
    }

    private WebElement emailAddress () {
        return getDriver ().findElement (with (By.tagName ("input")).below (subjectHeadingDropdown ()));
    }

    private WebElement message () {
        return getDriver ().findElement (with (By.tagName ("textarea")).toRightOf (subjectHeadingDropdown ()));
    }

    private WebElement orderReference () {
        return getDriver ().findElement (with (By.tagName ("input")).above (attachFileLabel ()));
    }

    private WebElement sendBtn () {
        return getDriver ().findElement (By.id ("submitMessage"));
    }

    private Select subjectHeading () {
        return new Select (subjectHeadingDropdown ());
    }

    private WebElement subjectHeadingDropdown () {
        return getDriver ().findElement (By.id ("id_contact"));
    }

}