package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;

/**
 * Created By Faisal Khatri on 19-04-2022
 */
public class OrderConfirmationPage {

    public String getOrderConfirmationMessage () {
        return getDriver ().findElement (By.cssSelector ("div > mat-card:nth-child(1) > div > div"))
            .getText ();
    }

    public String getOrderDeliveryMessage () {
        return getDriver ().findElement (By.cssSelector ("div.confirmation"))
            .getText ();
    }
    
    public String getThanksMessage () {
        return getDriver ().findElement (By.cssSelector ("h1.confirmation"))
            .getText ();
    }
}