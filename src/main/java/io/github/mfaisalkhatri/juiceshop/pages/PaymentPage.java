package io.github.mfaisalkhatri.juiceshop.pages;

import io.github.mfaisalkhatri.juiceshop.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class PaymentPage {
    private final WebDriver driver;
    private final Helper helper;

    public PaymentPage (WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
    }

    private WebElement addNewCard () {
        return driver.findElement(By.cssSelector("app-payment-method > div > div > mat-expansion-panel"));
    }

    private WebElement nameField () {
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(1) input"));
    }

    private WebElement cardNumberField () {
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(2) input"));
    }

    private Select expiryMonthField () {
        return new Select(driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(3) select")));
    }

    private Select expiryYearField () {
        return new Select(driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(4) select")));
    }

    private WebElement submitBtn () {
        return driver.findElement(By.id("submitButton"));
    }

    private WebElement selectAddressRadioBtn () {
        return driver.findElement(By.cssSelector("mat-cell > mat-radio-button"));
    }

    private WebElement continueBtn () {
        return driver.findElement(By.cssSelector(".btn.nextButton"));
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