package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private final DriverManager driverManager;
    private final WebDriverWait wait;
    private final Actions actions;
    private final MainPage mainPage;

    public ProductPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(30));
        actions = new Actions(driverManager.getDriver());
        mainPage = new MainPage(driverManager);
    }

    public String successMessage () {
        return driverManager.getDriver().findElement(By.cssSelector(".mat-simple-snack-bar-content")).getText();
    }

    public String getAppleJuicePrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public String getAppleJuiceText () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name")).getText();
    }

    private WebElement appleJuiceAddtoCartBtn () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div:nth-child(2) > button"));
    }

    public String getBananaJuicePrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public String getBananaJuiceText () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name")).getText();
    }

    private WebElement bananaJuiceAddtoCartBtn () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div:nth-child(2) > button"));
    }

    private WebElement overlay () {
        return driverManager.getDriver().findElement(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-transparent-backdrop.cdk-overlay-backdrop-showing"));
    }

    public void addAppleJuiceToCart () {
        overlay().click();
        actions.pause(Duration.ofSeconds(6)).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(appleJuiceAddtoCartBtn())).click();
    }

    public void addBananaJuiceToCart () {
        wait.until(ExpectedConditions.elementToBeClickable(bananaJuiceAddtoCartBtn())).click();
        actions.pause(Duration.ofSeconds(4)).build().perform();
    }

    public void navigateToYourBasket () {
        mainPage.yourBasketLink().click();
    }


}