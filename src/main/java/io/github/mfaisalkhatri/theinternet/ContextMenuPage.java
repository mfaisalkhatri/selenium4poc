package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 22-12-2021
 */
public class ContextMenuPage {

    private WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    Actions actions;

    public ContextMenuPage (WebDriver driver ) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public WebElement box () {
        return driver.findElement(By.id("hot-spot"));
    }

    public void checkForAlert () {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
    }

    public String getAlertText () {
        return alert.getText();
    }

    public void rightClick () {
        actions.contextClick(box()).perform();
    }
}