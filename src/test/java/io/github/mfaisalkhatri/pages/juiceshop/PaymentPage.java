package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class PaymentPage {

    public void makePayment (final String name, final String cardNumber, final String expiryMonth,
        final String expiryYear) {
        addNewCard ().click ();
        enterText (nameField (), name);
        enterText (cardNumberField (), cardNumber);
        expiryMonthField ().selectByValue (expiryMonth);
        expiryYearField ().selectByValue (expiryYear);
        submitBtn ().click ();
        selectAddressRadioBtn ().click ();
        continueBtn ().click ();
    }

    private WebElement addNewCard () {
        return getDriver ().findElement (By.cssSelector ("app-payment-method > div > div > mat-expansion-panel"));
    }

    private WebElement cardNumberField () {
        return getDriver ().findElement (
            By.cssSelector ("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(2) input"));
    }

    private WebElement continueBtn () {
        return getDriver ().findElement (By.cssSelector (".btn.nextButton"));
    }

    private Select expiryMonthField () {
        return new Select (getDriver ().findElement (
            By.cssSelector ("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(3) select")));
    }

    private Select expiryYearField () {
        return new Select (getDriver ().findElement (
            By.cssSelector ("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(4) select")));
    }

    private WebElement nameField () {
        return getDriver ().findElement (
            By.cssSelector ("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(1) input"));
    }

    private WebElement selectAddressRadioBtn () {
        return getDriver ().findElement (By.cssSelector ("mat-cell > mat-radio-button"));
    }

    private WebElement submitBtn () {
        return getDriver ().findElement (By.id ("submitButton"));
    }

}