package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private final MainPage mainPage;

    public ProductPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        mainPage = new MainPage(driver);
    }

    public String successMessage () {
        return driver.findElement(By.cssSelector(".mat-simple-snack-bar-content")).getText();
    }

    public String getAppleJuicePrice () {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public String getAppleJuiceText () {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name")).getText();
    }

    public WebElement appleJuiceAddtoCartBtn () {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div:nth-child(2) > button"));

    }

    public String getBananaJuicePrice () {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public String getBananaJuiceText () {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name")).getText();
    }

    public WebElement bananaJuiceAddtoCartBtn () {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div:nth-child(2) > button"));
    }

    public WebElement overlay () {
        return driver.findElement(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-transparent-backdrop.cdk-overlay-backdrop-showing"));
    }

    public void addAppleJuiceToCart () {
        overlay().click();
        actions.pause(Duration.ofSeconds(4)).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(appleJuiceAddtoCartBtn())).click();
    }

    public void addBananaJuiceToCart () {
        wait.until(ExpectedConditions.elementToBeClickable(bananaJuiceAddtoCartBtn())).click();
        actions.pause(Duration.ofSeconds(5)).build().perform();
    }

    public void navigateToYourBasket () {
        mainPage.yourBasketLink().click();
    }


}