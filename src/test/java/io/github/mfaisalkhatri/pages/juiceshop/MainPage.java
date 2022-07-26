package io.github.mfaisalkhatri.pages.juiceshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

public class MainPage {


    private WebElement meWantThisLink () {
        return getDriver().findElement(By.cssSelector(".cc-btn"));
    }

    private WebElement dismissBtn () {
        return getDriver().findElement(By.cssSelector(".close-dialog"));
    }

    public WebElement accountLink () {
        return getDriver().findElement(By.id("navbarAccount"));
    }

    private WebElement loginLink () {
        return getDriver().findElement(By.id("navbarLoginButton"));
    }

    public WebElement yourBasketLink () {
        return getDriver().findElement(By.cssSelector("button.mat-focus-indicator:nth-child(7)"));
    }

    public String yourBasketCount () {
        return getDriver().findElement(By.cssSelector(".fa-layers-counter")).getText();
    }

    public void openLoginPage () {
        Actions action = new Actions(getDriver());
        meWantThisLink().click();
        action.pause(Duration.ofSeconds(5)).moveToElement(dismissBtn()).click().build().perform();
        accountLink().click();
        loginLink().click();
    }


}