package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created By Faisal Khatri on 13-12-2021
 */
public class ABTestingPage {

    private WebDriver driver;

    public ABTestingPage (WebDriver driver) {
        this.driver = driver;
    }

    public String pageHeader () {
        return driver.findElement(By.tagName("h3")).getText();
    }

}