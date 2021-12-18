package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 18-12-2021
 */
public class JSAlertPage {

    private WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    public JSAlertPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement jsAlertButton () {
        return driver.findElement(By.cssSelector("ul > li:nth-child(1) > button"));
    }

    public WebElement jsConfirmButton () {
        return driver.findElement(By.cssSelector("ul > li:nth-child(2) > button"));
    }

    public WebElement jspromptButton () {
        return driver.findElement(By.cssSelector("ul > li:nth-child(3) > button"));
    }

    public void checkForAlert () {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
    }

    public void acceptAlert () {
        alert.accept();
    }

    public void dismissAlert () {
        alert.dismiss();
    }

    public String getAlertText() {
        return  alert.getText();
    }

    public void typeTextInAlert (String text) {
        alert.sendKeys(text);
    }
}