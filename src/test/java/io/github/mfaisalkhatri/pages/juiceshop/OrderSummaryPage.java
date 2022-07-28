package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 19-04-2022
 */
public class OrderSummaryPage {

    public String getAppleJuicePrice () {
        return getDriver ().findElement (By.cssSelector ("mat-table > mat-row:nth-child(2) > .mat-column-price"))
            .getText ();
    }

    public String getAppleJuiceQty () {
        return getDriver ().findElement (By.cssSelector ("mat-table > mat-row:nth-child(2) > .mat-column-quantity"))
            .getText ();
    }
    
    public String getAppleJuiceText () {
        return getDriver ().findElement (By.cssSelector ("mat-table > mat-row:nth-child(2) > .mat-column-product"))
            .getText ();
    }

    public String getBananaJuicePrice () {
        return getDriver ().findElement (By.cssSelector ("mat-table > mat-row:nth-child(3) > .mat-column-price"))
            .getText ();
    }

    public String getBananaJuiceQty () {
        return getDriver ().findElement (By.cssSelector ("mat-table > mat-row:nth-child(3) > .mat-column-quantity"))
            .getText ();
    }

    public String getBananaJuiceText () {
        return getDriver ().findElement (By.cssSelector ("mat-table > mat-row:nth-child(3) > .mat-column-product"))
            .getText ();
    }

    public String getDeliveryAddress () {
        return getDriver ().findElement (By.cssSelector ("mat-card:nth-child(1) > div > div:nth-child(3)"))
            .getText ();
    }

    public String getDeliveryAddressCountry () {
        return getDriver ().findElement (By.cssSelector ("mat-card:nth-child(1) > div > div:nth-child(4)"))
            .getText ();
    }

    public String getDeliveryAddressCustomerName () {
        return getDriver ().findElement (By.cssSelector ("mat-card:nth-child(1) > div > div:nth-child(2)"))
            .getText ();
    }

    public String getDeliveryAddressPhoneNumber () {
        return getDriver ().findElement (By.cssSelector ("mat-card:nth-child(1) > div > div:nth-child(5)"))
            .getText ();
    }

    public String getDeliveryAmount () {
        return getDriver ().findElement (By.cssSelector ("mat-card > table > tr:nth-child(2) > td.mat-cell.price"))
            .getText ();
    }

    public String getItemsPrice () {
        return getDriver ().findElement (By.cssSelector ("mat-card > table > tr:nth-child(1) > td.mat-cell.price"))
            .getText ();
    }

    public String getPaymentmethodCardEnding () {
        return getDriver ().findElement (By.cssSelector ("mat-card:nth-child(2) > div > div:nth-child(2)"))
            .getText ();
    }

    public String getPaymentmethodCardHolderName () {
        return getDriver ().findElement (By.cssSelector ("mat-card:nth-child(2) > div > div:nth-child(3)"))
            .getText ();
    }

    public String getTotalPrice () {
        return getDriver ().findElement (
                By.cssSelector ("mat-card > table > tr:nth-child(4) > td.mat-footer-cell.price"))
            .getText ();
    }

    public void placeOrderAndPay () {
        final Actions actions = new Actions (getDriver ());
        actions.pause (Duration.ofSeconds (5))
            .build ()
            .perform ();
        placeOrderButton ().click ();
    }

    private WebElement placeOrderButton () {
        return getDriver ().findElement (By.id ("checkoutButton"));
    }
}