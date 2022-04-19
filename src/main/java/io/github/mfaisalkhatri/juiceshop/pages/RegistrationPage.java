package io.github.mfaisalkhatri.juiceshop.pages;

import io.github.mfaisalkhatri.juiceshop.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    private final Helper helper;
    private final LoginPage loginPage;
    private final Actions actions;

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
        loginPage = new LoginPage(driver);
        actions = new Actions(driver);
    }

    public WebElement emailField () {
        return driver.findElement(By.id("emailControl"));
    }

    public WebElement passwordField () {
        return driver.findElement(By.id("passwordControl"));
    }

    public WebElement repeatPasswordField () {
        return driver.findElement(By.id("repeatPasswordControl"));
    }


    public void securityQuestionDropdown (String securityQuestion) {
        Actions action = new Actions(driver);
        WebElement dropdown = driver.findElement(By.name("securityQuestion"));
        action.pause(Duration.ofSeconds(2)).click(dropdown).perform();
        WebElement selectOption =
                driver.findElement(By.xpath("//mat-option/span[contains(text()," + "\"" + securityQuestion + "\")] "));
        action.pause(Duration.ofSeconds(2)).click(selectOption).perform();

    }

    public WebElement securityAnswer () {
        return driver.findElement(By.id("securityAnswerControl"));
    }

    public WebElement registrationButton () {
        return driver.findElement(By.id("registerButton"));
    }

    public String successMessage () {
        return driver.findElement(By.cssSelector(".cdk-overlay-pane > snack-bar-container > div > div > " +
                "simple-snack-bar >span")).getText();
    }

    public void registerUser (String email, String password, String securityQuestion, String securityAnswer) {
        actions.pause(Duration.ofSeconds(3)).click(loginPage.notaCustomerLink()).build().perform();
        helper.enterText(emailField(), email);
        helper.enterText(passwordField(), password);
        helper.enterText(repeatPasswordField(), password);
        securityQuestionDropdown(securityQuestion);
        helper.enterText(securityAnswer(), securityAnswer);
        registrationButton().click();

    }
}