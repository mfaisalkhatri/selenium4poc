package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 17-04-2022
 */
public class CheckoutPage {

    private final Actions     actions;
    private final AddressPage addressPage;

    public CheckoutPage () {
        this.actions = new Actions (getDriver ());
        this.addressPage = new AddressPage ();
    }

    public void addAddressForDelivery (final String country, final String name, final int mobileNumber,
        final String zipCode, final String address, final String city, final String state) {
        addNewAddressBtn ().click ();
        enterText (this.addressPage.countryField (), country);
        enterText (this.addressPage.nameField (), name);
        enterText (this.addressPage.mobileNumberField (), String.valueOf (mobileNumber));
        enterText (this.addressPage.zipCodeField (), zipCode);
        enterText (this.addressPage.addressField (), address);
        enterText (this.addressPage.cityField (), city);
        enterText (this.addressPage.stateField (), state);
        this.addressPage.submitBtn ()
            .click ();
        this.addressPage.selectAddressRadioBtn ()
            .click ();
        this.addressPage.continueBtn ()
            .click ();
    }

    public String appleJuicePrice () {
        return getDriver ().findElement (
                By.cssSelector ("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-price"))
            .getText ();
    }

    public String appleJuiceQty () {
        return getDriver ().findElement (
                By.cssSelector ("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-quantity > span"))
            .getText ();
    }

    public String appleJuiceText () {
        return getDriver ().findElement (
                By.cssSelector ("mat-table > mat-row:nth-child(2) > mat-cell.mat-column-product"))
            .getText ();
    }

    public String bananaJuicePrice () {
        return getDriver ().findElement (
                By.cssSelector ("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-price"))
            .getText ();
    }

    public String bananaJuiceQty () {
        return getDriver ().findElement (
                By.cssSelector ("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-quantity > span"))
            .getText ();
    }

    public String bananaJuiceText () {
        return getDriver ().findElement (
                By.cssSelector ("mat-table > mat-row:nth-child(3) > mat-cell.mat-column-product"))
            .getText ();
    }

    public WebElement checkoutBtn () {
        return getDriver ().findElement (By.id ("checkoutButton"));
    }

    public void checkoutProduct () {
        this.actions.pause (Duration.ofSeconds (5))
            .click (checkoutBtn ())
            .build ()
            .perform ();
    }

    public String totalPrice () {
        return getDriver ().findElement (By.id ("price"))
            .getText ();
    }

    private WebElement addNewAddressBtn () {
        return getDriver ().findElement (By.cssSelector ("mat-card > div > button"));
    }
}