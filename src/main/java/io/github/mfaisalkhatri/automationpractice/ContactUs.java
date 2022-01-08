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

package io.github.mfaisalkhatri.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
class ContactUs {

    private final WebDriver driver;

    ContactUs(WebDriver driver) {
        this.driver = driver;
    }

    String pageHeading() {
        return driver.findElement(By.tagName("h1")).getText();
    }


    private WebElement subjectHeadingDropdown() {
        return driver.findElement(By.id("id_contact"));
    }

    private Select subjectHeading() {
        return new Select(subjectHeadingDropdown());
    }

    private WebElement emailAddress() {
        return driver.findElement(with(By.tagName("input")).below(subjectHeadingDropdown()));
    }

    private WebElement attachFileLabel() {
        return driver.findElement(By.cssSelector("p:nth-child(7) > label"));
    }

    private WebElement orderReference() {
        return driver.findElement(with(By.tagName("input")).above(attachFileLabel()));
    }

    private WebElement message() {
        return driver.findElement(with(By.tagName("textarea")).toRightOf(subjectHeadingDropdown()));
    }

    private WebElement sendBtn() {
        return driver.findElement(By.id("submitMessage"));
    }

    String successSentMessage() {
        return driver.findElement(By.cssSelector("#center_column > p")).getText();
    }

    void fillContactForm(String subjectHeading, String emailId, String orderRef, String message) {
        subjectHeading().selectByVisibleText(subjectHeading);
        emailAddress().click();
        emailAddress().clear();
        emailAddress().sendKeys(emailId);
        orderReference().click();
        orderReference().clear();
        orderReference().sendKeys(orderRef);
        message().click();
        message().clear();
        message().sendKeys(message);
        sendBtn().click();
    }

}