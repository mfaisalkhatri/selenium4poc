package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RegistrationPage {

    private final DriverManager driverManager;
    private final Helper helper;
    private final LoginPage loginPage;
    private final Actions actions;

    public RegistrationPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        helper = new Helper();
        loginPage = new LoginPage(driverManager);
        actions = new Actions(driverManager.getDriver());
    }

    private WebElement emailField () {
        return driverManager.getDriver().findElement(By.id("emailControl"));
    }

    private WebElement passwordField () {
        return driverManager.getDriver().findElement(By.id("passwordControl"));
    }

    private WebElement repeatPasswordField () {
        return driverManager.getDriver().findElement(By.id("repeatPasswordControl"));
    }


    private void securityQuestionDropdown (String securityQuestion) {
        Actions action = new Actions(driverManager.getDriver());
        WebElement dropdown = driverManager.getDriver().findElement(By.name("securityQuestion"));
        action.pause(Duration.ofSeconds(2)).click(dropdown).perform();
        WebElement selectOption =
                driverManager.getDriver().findElement(By.xpath("//mat-option/span[contains(text()," + "\"" + securityQuestion + "\")] "));
        action.pause(Duration.ofSeconds(2)).click(selectOption).perform();

    }

    private WebElement securityAnswer () {
        return driverManager.getDriver().findElement(By.id("securityAnswerControl"));
    }

    private WebElement registrationButton () {
        return driverManager.getDriver().findElement(By.id("registerButton"));
    }

    public String successMessage () {
        return driverManager.getDriver().findElement(By.cssSelector(".cdk-overlay-pane > snack-bar-container > div > div > " +
                "simple-snack-bar >span")).getText();
    }

    public void registerUser (String email, String password, String securityQuestion, String securityAnswer) {
        actions.pause(Duration.ofSeconds(5)).click(loginPage.notaCustomerLink()).build().perform();
        helper.enterText(emailField(), email);
        helper.enterText(passwordField(), password);
        helper.enterText(repeatPasswordField(), password);
        securityQuestionDropdown(securityQuestion);
        helper.enterText(securityAnswer(), securityAnswer);
        registrationButton().click();

    }
}