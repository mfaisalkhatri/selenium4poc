package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class HomePage {

    public static HomePage homePage () {
        return new HomePage ();
    }

    public RegistrationPage openUserRegistrationPage () {
        openMyAccountMenu ().registerLink ()
            .click ();
        return new RegistrationPage ();
    }
    
    public ProductPage shopByCategory (final String linkName) {
        shopByCategory ().selectCategory (linkName)
            .click ();
        return new ProductPage ();
    }

    private WebElement loginLink () {
        return getDriver ().findElement (By.linkText ("Login"));
    }

    private HomePage openMyAccountMenu () {
        getDriver ().findElement (By.linkText ("My account"))
            .click ();
        return this;
    }

    private WebElement registerLink () {
        return getDriver ().findElement (By.linkText ("Register"));
    }

    private WebElement selectCategory (final String linkName) {
        return getDriver ().findElement (By.linkText (linkName));
    }

    private HomePage shopByCategory () {
        getDriver ().findElement (By.linkText ("Shop by Category"))
            .click ();
        return this;
    }

}