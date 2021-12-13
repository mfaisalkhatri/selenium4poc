package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.*;

/**
 * Created By Faisal Khatri on 13-12-2021
 */
public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink (String linkName) {
        WebElement link = driver.findElement(By.linkText(linkName));
        link.click();
    }

    public String mainPageHeader () {
        return driver.findElement(By.tagName("h2")).getText();
    }
}