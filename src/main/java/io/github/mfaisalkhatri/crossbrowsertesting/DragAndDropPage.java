package io.github.mfaisalkhatri.crossbrowsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 30-12-2021
 */
public class DragAndDropPage {

    private WebDriver driver;
    private Actions action;

    public DragAndDropPage (WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public WebElement draggable () {
        return driver.findElement(By.id("draggable"));
    }

    public WebElement droppable () {
        return driver.findElement(By.id ("droppable"));
    }

    public String getDroppableBoxText() {
        return driver.findElement(By.cssSelector("#droppable > p")).getText();

    }

    public void dragAndDropBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable(),droppable()).build().perform();
    }

}