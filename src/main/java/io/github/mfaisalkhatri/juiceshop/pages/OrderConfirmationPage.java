package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created By Faisal Khatri on 19-04-2022
 */
public class OrderConfirmationPage {

    private final WebDriver driver;

    public OrderConfirmationPage (WebDriver driver) {
        this.driver = driver;
    }

    public String getThanksMessage () {
        return driver.findElement(By.cssSelector("h1.confirmation")).getText();
    }

    public String getOrderConfirmationMessage () {
        return driver.findElement(By.cssSelector("div > mat-card:nth-child(1) > div > div")).getText();
    }

    public String getOrderDeliveryMessage () {
        return driver.findElement(By.cssSelector("div.confirmation")).getText();
    }
}