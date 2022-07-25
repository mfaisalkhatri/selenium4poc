package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;

/**
 * Created By Faisal Khatri on 19-04-2022
 */
public class OrderConfirmationPage {

    private final DriverManager driverManager;

    public OrderConfirmationPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String getThanksMessage () {
        return driverManager.getDriver().findElement(By.cssSelector("h1.confirmation")).getText();
    }

    public String getOrderConfirmationMessage () {
        return driverManager.getDriver().findElement(By.cssSelector("div > mat-card:nth-child(1) > div > div")).getText();
    }

    public String getOrderDeliveryMessage () {
        return driverManager.getDriver().findElement(By.cssSelector("div.confirmation")).getText();
    }
}