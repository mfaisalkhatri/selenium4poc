package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement meWantThisLink () {
        return driver.findElement(By.cssSelector(".cc-btn"));
    }

    public WebElement dismissBtn () {
        return driver.findElement(By.cssSelector(".close-dialog"));
    }

    public WebElement accountLink () {
        return driver.findElement(By.id("navbarAccount"));
    }

    public WebElement loginLink () {
        return driver.findElement(By.id("navbarLoginButton"));
    }

    public WebElement yourBasketLink () {
        return driver.findElement(By.cssSelector("button.mat-focus-indicator:nth-child(7)"));
    }

    public String yourBasketCount () {
        return driver.findElement(By.cssSelector(".fa-layers-counter")).getText();
    }

    public void openLoginPage () {
        Actions action = new Actions(driver);
        meWantThisLink().click();
        action.pause(Duration.ofSeconds(2)).moveToElement(dismissBtn()).click().build().perform();
        accountLink().click();
        loginLink().click();
    }


}