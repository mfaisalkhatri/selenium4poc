package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import io.github.mfaisalkhatri.testdata.RegisterUserData;
import io.github.mfaisalkhatri.testdata.RegistrationTestDataBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;
import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class RegistrationPage {

    private static final String PASSWORD = "Password123#";
    
    public RegistrationPage verifyPageHeader () {
        assertEquals(getDriver().findElement(By.tagName("h1")).getText(), "Register Account");
        return this;
    }

    public WebElement registrationForm () {
        return getDriver().findElement(By.id("content"));
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
        Actions actions = new Actions(getDriver());
        actions.moveToElement(agreePrivacyPolicyField()).click().perform();
        continueBtn().click();
        return new RegistrationSuccessPage();
    }

}