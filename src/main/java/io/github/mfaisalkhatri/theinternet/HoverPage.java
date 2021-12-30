package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class HoverPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HoverPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        action.moveToElement(element).click().build().perform();
    }

    public String getImageOneName () {
        return driver.findElement(By.cssSelector("div:nth-child(3) > div > h5")).getText();

    }
    public String getImageTwoName () {
        return driver.findElement(By.cssSelector("div:nth-child(4) > div > h5")).getText();

    }

    public String getImageThreeName () {
        return driver.findElement(By.cssSelector("div:nth-child(5) > div > h5")).getText();

    }
}