package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage {

    private final Actions actions;

    public RegistrationPage () {
        this.actions = new Actions (getDriver ());
    }

    public void registerUser (final String email, final String password, final String securityQuestion,
        final String securityAnswer) {
        final LoginPage loginPage = new LoginPage ();
        this.actions.pause (Duration.ofSeconds (5))
            .click (loginPage.notaCustomerLink ())
            .build ()
            .perform ();
        enterText (emailField (), email);
        enterText (passwordField (), password);
        enterText (repeatPasswordField (), password);
        securityQuestionDropdown (securityQuestion);
        enterText (securityAnswer (), securityAnswer);
        registrationButton ().click ();
    }

    public String successMessage () {
        return getDriver ().findElement (
                By.cssSelector (".cdk-overlay-pane > snack-bar-container > div > div > " + "simple-snack-bar >span"))
            .getText ();
    }

    private WebElement emailField () {
        return getDriver ().findElement (By.id ("emailControl"));
    }

    private WebElement passwordField () {
        return getDriver ().findElement (By.id ("passwordControl"));
    }

    private WebElement registrationButton () {
        return getDriver ().findElement (By.id ("registerButton"));
    }

    private WebElement repeatPasswordField () {
        return getDriver ().findElement (By.id ("repeatPasswordControl"));
    }

    private WebElement securityAnswer () {
        return getDriver ().findElement (By.id ("securityAnswerControl"));
    }

    private void securityQuestionDropdown (final String securityQuestion) {
        final Actions action = new Actions (getDriver ());
        final WebElement dropdown = getDriver ().findElement (By.name ("securityQuestion"));
        action.pause (Duration.ofSeconds (2))
            .click (dropdown)
            .perform ();
        final WebElement selectOption = getDriver ().findElement (
            By.xpath ("//mat-option/span[contains(text()," + "\"" + securityQuestion + "\")] "));
        action.pause (Duration.ofSeconds (2))
            .click (selectOption)
            .perform ();
    }
}