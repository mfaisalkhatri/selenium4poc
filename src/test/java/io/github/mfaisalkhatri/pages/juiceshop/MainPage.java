package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainPage {

    private final DriverManager driverManager;

    public MainPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    private WebElement meWantThisLink () {
        return driverManager.getDriver().findElement(By.cssSelector(".cc-btn"));
    }

    private WebElement dismissBtn () {
        return driverManager.getDriver().findElement(By.cssSelector(".close-dialog"));
    }

    public WebElement accountLink () {
        return driverManager.getDriver().findElement(By.id("navbarAccount"));
    }

    private WebElement loginLink () {
        return driverManager.getDriver().findElement(By.id("navbarLoginButton"));
    }

    public WebElement yourBasketLink () {
        return driverManager.getDriver().findElement(By.cssSelector("button.mat-focus-indicator:nth-child(7)"));
    }

    public String yourBasketCount () {
        return driverManager.getDriver().findElement(By.cssSelector(".fa-layers-counter")).getText();
    }

    public void openLoginPage () {
        Actions action = new Actions(driverManager.getDriver());
        meWantThisLink().click();
        action.pause(Duration.ofSeconds(5)).moveToElement(dismissBtn()).click().build().perform();
        accountLink().click();
        loginLink().click();
    }


}