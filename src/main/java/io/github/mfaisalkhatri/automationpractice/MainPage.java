package io.github.mfaisalkhatri.automationpractice;

import org.openqa.selenium.*;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement signInBtn() {
        return driver.findElement(By.className("login"));
    }
    public WebElement contactUsLink() {
        return driver.findElement(with(By.tagName("a")).toLeftOf(signInBtn()));
    }

}