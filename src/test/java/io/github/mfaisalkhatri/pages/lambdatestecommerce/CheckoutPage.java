package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 26-07-2022
 */
public class CheckoutPage {

    public CheckoutPage verifyUnitPrice (String unitPrice) {
        assertEquals(getDriver().findElement(By.cssSelector("#checkout-cart > table > tbody > tr > td:nth-child(4)")).getText(), unitPrice);
        return this;
    }

    private WebElement paymentAddressForm () {
        return getDriver().findElement(By.id("payment-address"));
    }

    private WebElement firstNameField () {
        return paymentAddressForm().findElement(By.id("input-payment-firstname"));
    }

    private WebElement lastNameField () {
        return paymentAddressForm().findElement(By.id("input-payment-lastname"));
    }

    private WebElement addressLineOne () {
        return paymentAddressForm().findElement(By.id("input-payment-address-1"));
    }

    private WebElement cityField () {
        return paymentAddressForm().findElement(By.id("input-payment-city"));
    }

    private WebElement postCodeField () {
        return paymentAddressForm().findElement(By.id("input-payment-postcode"));
    }

    private Select countryField () {
        return new Select(paymentAddressForm().findElement(By.id("input-payment-country")));
    }

    private Select stateField () {
        return new Select(paymentAddressForm().findElement(By.id("input-payment-zone")));
    }

    private WebElement agreeTermsAndConditionsField () {

        return getDriver().findElement(By.id("input-agree"));
    }

    private WebElement continueBtn () {
        return getDriver().findElement(By.cssSelector("button#button-save"));
    }

}