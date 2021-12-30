package io.github.mfaisalkhatri.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 30-12-2021
 */
public class ButtonsPage {

    private WebDriver driver;

    public ButtonsPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement btnDoubleCLick () {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public String getTextOnClick () {
        return driver.findElement(By.id("doubleClickMessage")).getText();
    }

    public void doubleClickonButton () {
        Actions action = new Actions(driver);
        action.doubleClick(btnDoubleCLick()).perform();
    }
}