package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 19-04-2022
 */
public class OrderSummaryPage {

    private final DriverManager driverManager;
    private final Actions actions;

    public OrderSummaryPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        actions = new Actions(driverManager.getDriver());
    }

    public String getItemsPrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > table > tr:nth-child(1) > td.mat-cell.price")).getText();
    }

    public String getDeliveryAmount () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > table > tr:nth-child(2) > td.mat-cell.price")).getText();
    }

    public String getTotalPrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > table > tr:nth-child(4) > td.mat-footer-cell.price")).getText();
    }

    private WebElement placeOrderButton () {
        return driverManager.getDriver().findElement(By.id("checkoutButton"));
    }

    public String getDeliveryAddressCustomerName () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(2)")).getText();
    }

    public String getDeliveryAddress () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(3)")).getText();
    }

    public String getDeliveryAddressCountry () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(4)")).getText();
    }

    public String getDeliveryAddressPhoneNumber () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(5)")).getText();
    }

    public String getPaymentmethodCardEnding () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card:nth-child(2) > div > div:nth-child(2)")).getText();
    }

    public String getPaymentmethodCardHolderName () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card:nth-child(2) > div > div:nth-child(3)")).getText();
    }

    public String getAppleJuiceText () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > .mat-column-product")).getText();
    }

    public String getAppleJuicePrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > .mat-column-price")).getText();
    }

    public String getAppleJuiceQty () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > .mat-column-quantity")).getText();
    }

    public String getBananaJuiceText () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > .mat-column-product")).getText();
    }

    public String getBananaJuicePrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > .mat-column-price")).getText();
    }

    public String getBananaJuiceQty () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > .mat-column-quantity")).getText();
    }

    public void placeOrderAndPay () {
        actions.pause(Duration.ofSeconds(5)).build().perform();
        placeOrderButton().click();
    }
}