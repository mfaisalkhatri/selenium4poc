package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class RegistrationSuccessPage {

    public MyAccountPage continueToMyAccount () {
        continueBtn ().click ();
        return new MyAccountPage ();
    }

    public RegistrationSuccessPage verifySuccessfulRegistration () {
        assertEquals (getDriver ().findElement (By.tagName ("h1"))
            .getText (), "Your Account Has Been Created!");
        return this;
    }
    
    private WebElement continueBtn () {
        return getDriver ().findElement (By.cssSelector (".buttons > a.btn-primary"));
    }
}