package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class HoverPage {

    private WebDriver driver;

    public HoverPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement imageOne() {
        return driver.findElement(By.cssSelector("div:nth-child(3) > img"));
    }

    public WebElement imageTwo() {
        return driver.findElement(By.cssSelector("div:nth-child(4) > img"));
    }
    public WebElement imageThree() {
        return driver.findElement(By.cssSelector("div:nth-child(5) > img"));
    }

    public void hoverOnImage (WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public String getImageName () {
        return driver.findElement(By.tagName("h5")).getText();
    }
}