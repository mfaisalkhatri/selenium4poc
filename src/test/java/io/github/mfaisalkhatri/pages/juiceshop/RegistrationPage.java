package io.github.mfaisalkhatri.pages.juiceshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;


public class RegistrationPage {

    private final Actions actions;

    public RegistrationPage () {

        actions = new Actions(getDriver());
    }

    private WebElement emailField () {
        return getDriver().findElement(By.id("emailControl"));
    }

    private WebElement passwordField () {
        return getDriver().findElement(By.id("passwordControl"));
    }

    private WebElement repeatPasswordField () {
        return getDriver().findElement(By.id("repeatPasswordControl"));
    }

    private void securityQuestionDropdown (String securityQuestion) {
        Actions action = new Actions(getDriver());
        WebElement dropdown = getDriver().findElement(By.name("securityQuestion"));
        action.pause(Duration.ofSeconds(2)).click(dropdown).perform();
        WebElement selectOption =
                getDriver().findElement(By.xpath("//mat-option/span[contains(text()," + "\"" + securityQuestion + "\")] "));
        action.pause(Duration.ofSeconds(2)).click(selectOption).perform();
    }

    private WebElement securityAnswer () {
        return getDriver().findElement(By.id("securityAnswerControl"));
    }

    private WebElement registrationButton () {
        return getDriver().findElement(By.id("registerButton"));
    }

    public String successMessage () {
        return getDriver().findElement(By.cssSelector(".cdk-overlay-pane > snack-bar-container > div > div > " +
                "simple-snack-bar >span")).getText();
    }

    public void registerUser (String email, String password, String securityQuestion, String securityAnswer) {
        LoginPage loginPage = new LoginPage();
        actions.pause(Duration.ofSeconds(5)).click(loginPage.notaCustomerLink()).build().perform();
        enterText(emailField(), email);
        enterText(passwordField(), password);
        enterText(repeatPasswordField(), password);
        securityQuestionDropdown(securityQuestion);
        enterText(securityAnswer(), securityAnswer);
        registrationButton().click();
    }
}