package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import io.github.mfaisalkhatri.testdata.BillingData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;

/**
 * Created By Faisal Khatri on 26-07-2022
 */
public class CheckoutPage {

    public static CheckoutPage checkoutPage () {
        return new CheckoutPage ();
    }

    public String getUnitPriceOfCameraLens () {
        return getDriver ().findElement (By.cssSelector ("#checkout-total > tbody > tr:nth-child(1) > td.text-right"))
            .getText ();
    }

    private WebElement paymentAddressForm () {
        return getDriver ().findElement (By.id ("payment-address"));
    }

    private WebElement firstNameField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-firstname"));
    }

    private WebElement lastNameField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-lastname"));
    }

    private WebElement addressLineOneField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-address-1"));
    }

    private WebElement cityField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-city"));
    }

    private WebElement postCodeField () {
        return paymentAddressForm ().findElement (By.id ("input-payment-postcode"));
    }

    private Select countryField () {
        return new Select (paymentAddressForm ().findElement (By.id ("input-payment-country")));
    }

    private Select stateField () {
        return new Select (paymentAddressForm ().findElement (By.id ("input-payment-zone")));
    }

    private WebElement agreeTermsAndConditionsField () {
        return getDriver ().findElement (By.id ("input-agree"));
    }

    private WebElement continueBtn () {
        return getDriver ().findElement (By.id ("button-save"));
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

    public ConfirmOrderPage checkoutProduct () {
        final Actions actions = new Actions (getDriver ());
        actions.moveToElement (agreeTermsAndConditionsField ())
            .click ()
            .moveToElement (continueBtn ())
            .click ()
            .perform ();
        return ConfirmOrderPage.confirmOrderPage ();
    }
}