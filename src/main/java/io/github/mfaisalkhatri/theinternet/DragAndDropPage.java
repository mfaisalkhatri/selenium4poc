package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class DragAndDropPage {

    private WebDriver driver;
    private Actions action;

    public DragAndDropPage (WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public WebElement boxA() {
        return driver.findElement(By.id("column-a"));
    }

    public WebElement boxB () {
        return driver.findElement(By.id("column-b"));
    }

    public String getHeaderOfBoxA() {
        WebElement header = driver.findElement(By.cssSelector("#column-a > header"));
        return header.getText();
    }

    public String getHeaderOfBoxB() {
        WebElement header = driver.findElement(By.cssSelector("#column-b > header"));
        return header.getText();
    }

    public void dragBoxADropInBoxB () {
        action.dragAndDrop(boxA(),boxB()).build().perform();
    }

    public void dragBoxBDropInBoxA () {
        action.dragAndDrop(boxB(),boxA()).build().perform();
    }
}