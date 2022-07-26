package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class RegistrationSuccessPage {
    
    private WebElement continueBtn () {
        return getDriver().findElement(By.cssSelector(".buttons > a.btn-primary"));
    }

    public RegistrationSuccessPage verifySuccessfulRegistration () {
        assertEquals(getDriver().findElement(By.tagName("h1")).getText(), "Your Account Has Been Created!");
        return this;
    }

    public MyAccountPage continueToMyAccount () {
        continueBtn().click();
        return new MyAccountPage();
    }

}