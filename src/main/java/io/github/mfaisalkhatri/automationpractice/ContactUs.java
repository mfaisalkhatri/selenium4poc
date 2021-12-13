package io.github.mfaisalkhatri.automationpractice;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class ContactUs {

    private WebDriver driver;

    public ContactUs (WebDriver driver) {
        this.driver = driver;
    }

    public String pageHeading () {
        return driver.findElement(By.tagName("h1")).getText();
    }


    public WebElement subjectHeadingDropdown () {
        return driver.findElement(By.id("id_contact"));
    }

    public Select subjectHeading () {
        Select select = new Select(subjectHeadingDropdown());
        return select;
    }

    public WebElement emailAddress () {
        return driver.findElement(with(By.tagName("input")).below(subjectHeadingDropdown()));
    }

    public WebElement attachFileLabel () {
        return driver.findElement(By.cssSelector("p:nth-child(7) > label"));
    }

    public WebElement orderReference () {
        return driver.findElement(with(By.tagName("input")).above(attachFileLabel()));
    }

    public WebElement message () {
        return driver.findElement(with(By.tagName("textarea")).toRightOf(subjectHeadingDropdown()));
    }

    public WebElement sendBtn () {
        return driver.findElement(By.id("submitMessage"));
    }

    public String successSentMessage() {
        return driver.findElement(By.cssSelector("#center_column > p")).getText();
    }

    public void fillContactForm (String subjectHeading, String emailId, String orderRef, String message) {
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