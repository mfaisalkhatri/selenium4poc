package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class HomePage {

    private DriverManager driverManager;

    public HomePage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement myAccountLink () {
        return driverManager.getDriver().findElement(By.linkText("My account"));
    }

    public WebElement loginLink () {
        return driverManager.getDriver().findElement(By.linkText("Login"));
    }

    public WebElement registerLink () {
        return driverManager.getDriver().findElement(By.linkText("Register"));
    }

    public void openUserRegistrationPage () {
        myAccountLink().click();
        registerLink().click();
    }


}