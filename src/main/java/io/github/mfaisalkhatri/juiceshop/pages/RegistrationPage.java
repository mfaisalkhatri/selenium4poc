package io.github.mfaisalkhatri.juiceshop.pages;

import io.github.mfaisalkhatri.juiceshop.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    private final WebDriver driver;
    private final Helper helper;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
    }

    public WebElement emailField() {
        return driver.findElement(By.id("emailControl"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("passwordControl"));
    }

    public WebElement repeatPasswordField() {
        return driver.findElement(By.id("repeatPasswordControl"));
    }

    public Select securityQuestion() {
        WebElement dropdownBox = driver.findElement(By.cssSelector(".mat-form-field.ng-tns-c118-10 > div"));
        dropdownBox.click();
        return new Select(dropdownBox);
    }

    public WebElement securityAnswer() {
        return driver.findElement(By.cssSelector("mat-form-field.ng-tns-c118-12 > div"));
    }

    public WebElement registrationButton() {
        return driver.findElement(By.id("registerButton"));
    }

    public void registerUser(String email, String password, String securityQuestion, String securityAnswer) {
        helper.enterText(emailField(), email);
        helper.enterText(passwordField(), password);
        securityQuestion().selectByVisibleText(securityQuestion);
        helper.enterText(securityAnswer(), securityAnswer);
        registrationButton().click();
    }
}
