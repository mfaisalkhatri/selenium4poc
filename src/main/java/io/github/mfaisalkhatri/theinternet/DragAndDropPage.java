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

    public DragAndDropPage (WebDriver driver) {
        this.driver = driver;
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

    public void dragBoxAndDropInBoxB () {
        Actions action = new Actions(driver);
        action.dragAndDrop(boxA(),boxB());
    }

    public void dragBoxBndDropInBoxA () {
        Actions action = new Actions(driver);
        action.dragAndDrop(boxB(),boxA());
    }
}