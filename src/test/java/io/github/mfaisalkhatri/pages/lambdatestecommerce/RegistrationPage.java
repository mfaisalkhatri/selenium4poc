package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.testdata.RegisterUserData;
import io.github.mfaisalkhatri.testdata.RegistrationTestDataBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static io.github.mfaisalkhatri.utilities.Helper.enterText;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class RegistrationPage {

    private static final String PASSWORD = "Password123#";
    private DriverManager driverManager;

    public RegistrationPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String pageHeader () {
        return driverManager.getDriver().findElement(By.tagName("h1")).getText();
    }

    public WebElement registrationForm () {
        return driverManager.getDriver().findElement(By.id("content"));
    }

    public WebElement firstNameField () {
        return registrationForm().findElement(By.id("input-firstname"));
    }

    public WebElement lastNameField () {
        return registrationForm().findElement(By.id("input-lastname"));
    }

    public WebElement emailField () {
        return registrationForm().findElement(By.id("input-email"));
    }

    public WebElement telephoneField () {
        return registrationForm().findElement(By.id("input-telephone"));
    }

    public WebElement passwordField () {
        return registrationForm().findElement(By.id("input-password"));
    }

    public WebElement confirmPasswordField () {
        return registrationForm().findElement(By.id("input-confirm"));
    }

    public WebElement agreePrivacyPolicyField () {
        return registrationForm().findElement(By.id("input-agree"));
    }

    public WebElement continueBtn () {
        return registrationForm().findElement(By.cssSelector("input.btn-primary"));
    }

    public RegistrationSuccessPage registerUser () {

        RegistrationTestDataBuilder builder = new RegistrationTestDataBuilder();
        RegisterUserData registerUser = builder.registerUserDataBuilder();

        enterText(firstNameField(), registerUser.getFirstName());
        enterText(lastNameField(), registerUser.getLastName());
        enterText(emailField(), registerUser.getEmail());
        enterText(telephoneField(), registerUser.getTelephone());
        enterText(passwordField(), PASSWORD);
        enterText(confirmPasswordField(), PASSWORD);
        Actions actions = new Actions(driverManager.getDriver());
        actions.moveToElement(agreePrivacyPolicyField()).click().perform();
        continueBtn().click();
        return new RegistrationSuccessPage(driverManager);
    }

}