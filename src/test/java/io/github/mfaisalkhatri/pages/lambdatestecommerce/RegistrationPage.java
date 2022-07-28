package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;
import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.testdata.RegisterUserData;
import io.github.mfaisalkhatri.testdata.TestDataBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class RegistrationPage {

    private static final String           PASSWORD = "Password123#";
    private final        RegisterUserData registerUserData;

    public RegistrationPage () {
        this.registerUserData = TestDataBuilder.getRegisterUserData ();
    }

    public WebElement agreePrivacyPolicyField () {
        return registrationForm ().findElement (By.id ("input-agree"));
    }

    public WebElement confirmPasswordField () {
        return registrationForm ().findElement (By.id ("input-confirm"));
    }

    public WebElement continueBtn () {
        return registrationForm ().findElement (By.cssSelector ("input.btn-primary"));
    }

    public WebElement emailField () {
        return registrationForm ().findElement (By.id ("input-email"));
    }

    public WebElement firstNameField () {
        return registrationForm ().findElement (By.id ("input-firstname"));
    }

    public WebElement lastNameField () {
        return registrationForm ().findElement (By.id ("input-lastname"));
    }

    public WebElement passwordField () {
        return registrationForm ().findElement (By.id ("input-password"));
    }

    public RegistrationSuccessPage registerUser () {
        enterText (firstNameField (), this.registerUserData.getFirstName ());
        enterText (lastNameField (), this.registerUserData.getLastName ());
        enterText (emailField (), this.registerUserData.getEmail ());
        enterText (telephoneField (), this.registerUserData.getTelephone ());
        enterText (passwordField (), PASSWORD);
        enterText (confirmPasswordField (), PASSWORD);
        final Actions actions = new Actions (getDriver ());
        actions.moveToElement (agreePrivacyPolicyField ())
            .click ()
            .perform ();
        continueBtn ().click ();
        return new RegistrationSuccessPage ();
    }

    public WebElement registrationForm () {
        return getDriver ().findElement (By.id ("content"));
    }
    
    public WebElement telephoneField () {
        return registrationForm ().findElement (By.id ("input-telephone"));
    }

    public RegistrationPage verifyPageHeader () {
        assertEquals (getDriver ().findElement (By.tagName ("h1"))
            .getText (), "Register Account");
        return this;
    }

}