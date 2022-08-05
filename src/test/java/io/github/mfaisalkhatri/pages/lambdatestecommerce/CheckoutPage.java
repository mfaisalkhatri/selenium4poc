package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;

import java.time.Duration;

import io.github.mfaisalkhatri.data.BillingData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created By Faisal Khatri on 26-07-2022
 */
public class CheckoutPage {

    public static CheckoutPage checkoutPage () {
        return new CheckoutPage ();
    }

    private final WebDriverWait wait;

    private CheckoutPage () {
        this.wait = new WebDriverWait (getDriver (), Duration.ofSeconds (10));
    }

    public ConfirmOrderPage checkoutProduct () {
        agreeTermsAndConditionsField ().click ();
        continueBtn ().click ();
        return new ConfirmOrderPage ();
    }

    public String getUnitPriceOfCameraLens () {
        return getDriver ().findElement (By.cssSelector ("#checkout-total > tbody > tr:nth-child(1) > td.text-right"))
            .getText ();
    }

    public CheckoutPage setBillingAddress (final BillingData billingData) {
        enterText (firstNameField (), billingData.getFirstName ());
        enterText (lastNameField (), billingData.getLastName ());
        enterText (addressLineOneField (), billingData.getAddressLineOne ());
        enterText (cityField (), billingData.getCity ());
        enterText (postCodeField (), billingData.getPostCode ());
        countryField ().selectByVisibleText (billingData.getCountry ());
        stateField ().selectByVisibleText (billingData.getState ());
        return this;
    }

    private WebElement addressLineOneField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-address-1"));
    }

    private WebElement agreeTermsAndConditionsField () {
        return getDriver ().findElement (By.cssSelector ("#input-agree +label"));
    }

    private WebElement cityField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-city"));
    }

    private WebElement continueBtn () {
        return this.wait.until (ExpectedConditions.elementToBeClickable (By.cssSelector ("button#button-save")));
    }

    private Select countryField () {
        return new Select (paymentAddressForm ().findElement (By.id ("input-payment-country")));
    }

    private WebElement firstNameField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-firstname"));
    }

    private WebElement lastNameField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-lastname"));
    }

    private WebElement paymentAddressForm () {
        return getDriver ().findElement (By.id ("payment-address"));
    }

    private WebElement postCodeField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-postcode"));
    }

    private Select stateField () {
        return new Select (paymentAddressForm ().findElement (By.id ("input-payment-zone")));
    }
}