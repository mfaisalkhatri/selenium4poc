package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private final Actions       actions;
    private final WebDriverWait wait;

    public ProductPage () {
        this.wait = new WebDriverWait (getDriver (), Duration.ofSeconds (40));
        this.actions = new Actions (getDriver ());
    }

    public void addAppleJuiceToCart () {
        overlay ().click ();
        this.actions.pause (Duration.ofSeconds (6))
            .build ()
            .perform ();
        this.wait.until (ExpectedConditions.elementToBeClickable (appleJuiceAddtoCartBtn ()))
            .click ();
    }

    public void addBananaJuiceToCart () {
        this.wait.until (ExpectedConditions.elementToBeClickable (bananaJuiceAddtoCartBtn ()))
            .click ();
        this.actions.pause (Duration.ofSeconds (4))
            .build ()
            .perform ();
    }

    public String getAppleJuicePrice () {
        return getDriver ().findElement (By.cssSelector (
                "mat-grid-tile:nth-child(1) > div > mat-card > div" + ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span"))
            .getText ();
    }

    public String getAppleJuiceText () {
        return getDriver ().findElement (By.cssSelector (
                "mat-grid-tile:nth-child(1) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name"))
            .getText ();
    }

    public String getBananaJuicePrice () {
        return getDriver ().findElement (By.cssSelector (
                "mat-grid-tile:nth-child(3) > div > mat-card > div" + ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span"))
            .getText ();
    }

    public String getBananaJuiceText () {
        return getDriver ().findElement (By.cssSelector (
                "mat-grid-tile:nth-child(3) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name"))
            .getText ();
    }

    public void navigateToYourBasket () {
        final MainPage mainPage = new MainPage ();
        mainPage.yourBasketLink ()
            .click ();
    }

    public String successMessage () {
        return wait.until (
                ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".mat-simple-snack-bar-content")))
            .getText ();
    }

    private WebElement appleJuiceAddtoCartBtn () {
        return getDriver ().findElement (
            By.cssSelector ("mat-grid-tile:nth-child(1) > div > mat-card > div:nth-child(2) > button"));
    }

    private WebElement bananaJuiceAddtoCartBtn () {
        return getDriver ().findElement (
            By.cssSelector ("mat-grid-tile:nth-child(3) > div > mat-card > div:nth-child(2) > button"));
    }

    private WebElement overlay () {
        return getDriver ().findElement (
            By.cssSelector (".cdk-overlay-backdrop.cdk-overlay-transparent-backdrop.cdk-overlay-backdrop-showing"));
    }

}