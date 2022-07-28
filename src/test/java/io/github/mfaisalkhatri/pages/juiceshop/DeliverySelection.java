package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class DeliverySelection {

    public WebElement continueBtn () {
        return getDriver ().findElement (By.cssSelector (".btn.nextButton"));
    }
    
    public String getDeliveryAddress () {
        return getDriver ().findElement (By.cssSelector ("mat-card > div.addressCont > div:nth-child(3)"))
            .getText ();
    }

    public String getDeliveryAddressCountry () {
        return getDriver ().findElement (By.cssSelector ("mat-card > div.addressCont > div:nth-child(4)"))
            .getText ();
    }

    public String getDeliveryAddressName () {
        return getDriver ().findElement (By.cssSelector ("mat-card > div.addressCont > div:nth-child(2)"))
            .getText ();
    }

    public String getDeliveryAddressPhoneNumber () {
        return getDriver ().findElement (By.cssSelector ("mat-card > div.addressCont > div:nth-child(5)"))
            .getText ();
    }

    public WebElement oneDayDeliveryOption () {
        return getDriver ().findElement (By.cssSelector ("input.mat-radio-input"));
    }

    public void selectDeliveryOption () {
        final Actions actions = new Actions (getDriver ());
        actions.pause (Duration.ofSeconds (5))
            .click (oneDayDeliveryOption ())
            .build ()
            .perform ();
        continueBtn ().click ();
    }
}