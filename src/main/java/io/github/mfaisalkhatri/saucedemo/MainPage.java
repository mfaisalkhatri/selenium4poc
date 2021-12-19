package io.github.mfaisalkhatri.saucedemo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class MainPage {

    // private WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriver driver) {
        // this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement menuBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));

    }

    public WebElement logoutLink() {
        return wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("#logout_sidebar_link"))));
    }

    public void logoutFromWebSite() {
        menuBtn().click();
        logoutLink().click();
    }
}