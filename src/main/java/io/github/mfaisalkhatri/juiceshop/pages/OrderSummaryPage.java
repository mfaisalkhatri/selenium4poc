package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 19-04-2022
 */
public class OrderSummaryPage {

    private final WebDriver driver;
    private final Actions actions;

    public OrderSummaryPage (WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public String getItemsPrice () {
        return driver.findElement(By.cssSelector("mat-card > table > tr:nth-child(1) > td.mat-cell.price")).getText();
    }

    public String getDeliveryAmount () {
        return driver.findElement(By.cssSelector("mat-card > table > tr:nth-child(2) > td.mat-cell.price")).getText();
    }

    public String getTotalPrice () {
        return driver.findElement(By.cssSelector("mat-card > table > tr:nth-child(4) > td.mat-footer-cell.price")).getText();
    }

    private WebElement placeOrderButton () {
        return driver.findElement(By.id("checkoutButton"));
    }

    public String getDeliveryAddressCustomerName () {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(2)")).getText();
    }

    public String getDeliveryAddress () {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(3)")).getText();
    }

    public String getDeliveryAddressCountry () {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(4)")).getText();
    }

    public String getDeliveryAddressPhoneNumber () {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(5)")).getText();
    }

    public String getPaymentmethodCardEnding () {
        return driver.findElement(By.cssSelector("mat-card:nth-child(2) > div > div:nth-child(2)")).getText();
    }

    public String getPaymentmethodCardHolderName () {
        return driver.findElement(By.cssSelector("mat-card:nth-child(2) > div > div:nth-child(3)")).getText();
    }

    public String getAppleJuiceText () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > .mat-column-product")).getText();
    }

    public String getAppleJuicePrice () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > .mat-column-price")).getText();
    }

    public String getAppleJuiceQty () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > .mat-column-quantity")).getText();
    }

    public String getBananaJuiceText () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > .mat-column-product")).getText();
    }

    public String getBananaJuicePrice () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > .mat-column-price")).getText();
    }

    public String getBananaJuiceQty () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > .mat-column-quantity")).getText();
    }

    public void placeOrderAndPay () {
        actions.pause(Duration.ofSeconds(4)).build().perform();
        placeOrderButton().click();
    }
}