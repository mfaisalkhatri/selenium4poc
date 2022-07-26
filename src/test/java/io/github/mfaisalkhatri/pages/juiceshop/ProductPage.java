package io.github.mfaisalkhatri.pages.juiceshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

public class ProductPage {

    private final WebDriverWait wait;
    private final Actions actions;

    public ProductPage () {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        actions = new Actions(getDriver());
    }

    public String successMessage () {
        return getDriver().findElement(By.cssSelector(".mat-simple-snack-bar-content")).getText();
    }

    public String getAppleJuicePrice () {
        return getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public String getAppleJuiceText () {
        return getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name")).getText();
    }

    private WebElement appleJuiceAddtoCartBtn () {
        return getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div:nth-child(2) > button"));
    }

    public String getBananaJuicePrice () {
        return getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public String getBananaJuiceText () {
        return getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > .mat-tooltip-trigger.product > div:nth-child(2) > .item-name")).getText();
    }

    private WebElement bananaJuiceAddtoCartBtn () {
        return getDriver().findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div:nth-child(2) > button"));
    }

    private WebElement overlay () {
        return getDriver().findElement(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-transparent-backdrop.cdk-overlay-backdrop-showing"));
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
        MainPage mainPage = new MainPage();
        mainPage.yourBasketLink().click();
    }


}