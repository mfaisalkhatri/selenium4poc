package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class RegistrationSuccessPage {

    private DriverManager driverManager;

    public RegistrationSuccessPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement continueBtn () {
        return driverManager.getDriver().findElement(By.cssSelector(".buttons > a.btn-primary"));
    }

    public String registrationSuccessfulMessage () {
        return driverManager.getDriver().findElement(By.tagName("h1")).getText();
    }

    public MyAccountPage continueToMyAccount () {
        continueBtn().click();
        return new MyAccountPage(driverManager);
    }

}