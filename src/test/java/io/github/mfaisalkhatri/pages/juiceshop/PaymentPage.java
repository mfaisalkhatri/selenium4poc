package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class PaymentPage {
    private final DriverManager driverManager;
    private final Helper helper;

    public PaymentPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        helper = new Helper();
    }

    private WebElement addNewCard () {
        return driverManager.getDriver().findElement(By.cssSelector("app-payment-method > div > div > mat-expansion-panel"));
    }

    private WebElement nameField () {
        return driverManager.getDriver().findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(1) input"));
    }

    private WebElement cardNumberField () {
        return driverManager.getDriver().findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(2) input"));
    }

    private Select expiryMonthField () {
        return new Select(driverManager.getDriver().findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(3) select")));
    }

    private Select expiryYearField () {
        return new Select(driverManager.getDriver().findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(4) select")));
    }

    private WebElement submitBtn () {
        return driverManager.getDriver().findElement(By.id("submitButton"));
    }

    private WebElement selectAddressRadioBtn () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-cell > mat-radio-button"));
    }

    private WebElement continueBtn () {
        return driverManager.getDriver().findElement(By.cssSelector(".btn.nextButton"));
    }

    public void makePayment (String name, String cardNumber, String expiryMonth, String expiryYear) {
        addNewCard().click();
        helper.enterText(nameField(), name);
        helper.enterText(cardNumberField(), cardNumber);
        expiryMonthField().selectByValue(expiryMonth);
        expiryYearField().selectByValue(expiryYear);
        submitBtn().click();
        selectAddressRadioBtn().click();
        continueBtn().click();
    }

}