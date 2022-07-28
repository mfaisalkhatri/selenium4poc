package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class AddressPage {

    public WebElement addressField () {
        return addressForm ().findElement (By.cssSelector (".mat-form-field:nth-child(5) textarea"));
    }

    public WebElement addressForm () {
        return getDriver ().findElement (By.id ("address-form"));
    }

    public WebElement cityField () {
        return addressForm ().findElement (By.cssSelector (".mat-form-field:nth-child(6) input"));
    }
    
    public WebElement continueBtn () {
        return getDriver ().findElement (By.cssSelector (".btn.btn-next"));
    }

    public WebElement countryField () {
        return addressForm ().findElement (By.cssSelector (".mat-form-field:nth-child(1) input"));
    }

    public WebElement mobileNumberField () {
        return addressForm ().findElement (By.cssSelector (".mat-form-field:nth-child(3) input"));
    }

    public WebElement nameField () {
        return addressForm ().findElement (By.cssSelector (".mat-form-field:nth-child(2) input"));
    }

    public WebElement selectAddressRadioBtn () {
        return getDriver ().findElement (By.cssSelector ("mat-cell > mat-radio-button"));
    }

    public WebElement stateField () {
        return addressForm ().findElement (By.cssSelector (".mat-form-field:nth-child(7) input"));
    }

    public WebElement submitBtn () {
        return getDriver ().findElement (By.id ("submitButton"));
    }

    public WebElement zipCodeField () {
        return addressForm ().findElement (By.cssSelector (".mat-form-field:nth-child(4) input"));
    }
}