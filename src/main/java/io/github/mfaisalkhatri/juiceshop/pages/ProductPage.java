package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement successMessage() {
        return driver.findElement(By.cssSelector("mat-simple-snack-bar-content"));
    }

    public String appleJuicePrice() {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public WebElement appleJuiceAddtoCartBtn() {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(1) > div > mat-card > div:nth-child(2) > " +
                "button"));
    }

    public String bananaJuicePrice() {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div" +
                ".mat-tooltip-trigger.product > div:nth-child(2) > div.item-price > span")).getText();
    }

    public WebElement bananaJuiceAddtoCartBtn() {
        return driver.findElement(By.cssSelector("mat-grid-tile:nth-child(3) > div > mat-card > div:nth-child" +
                "(2) > button"));
    }

}
