package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class PaymentPage {
    private WebDriver driver;

    public WebElement addNewCard () {
        return driver.findElement(By.cssSelector("app-payment-method > div > div > mat-expansion-panel"));
    }

    public WebElement nameField () {
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(1) input"));
    }

    public WebElement cardNumberField () {
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(2) input"));
    }

    public WebElement expiryMonthField () {
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(3) select"));
    }

    public WebElement expiryYearField () {
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(4`) select"));
    }
}