package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;


/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class HomePage {

    private HomePage () {
    }

    public static HomePage homePage () {
        return new HomePage();
    }

    private HomePage openMyAccountMenu () {
        getDriver().findElement(By.linkText("My account")).click();
        return this;
    }

    private WebElement loginLink () {
        return getDriver().findElement(By.linkText("Login"));
    }

    private WebElement registerLink () {
        return getDriver().findElement(By.linkText("Register"));
    }

    private HomePage shopByCategory () {
        getDriver().findElement(By.linkText("Shop by Category")).click();
        return this;
    }

    private WebElement selectCategory (String linkName) {
        return getDriver().findElement(By.linkText(linkName));
    }

    public RegistrationPage openUserRegistrationPage () {
        openMyAccountMenu().registerLink().click();
        return new RegistrationPage();
    }

    public ProductPage shopByCategory (String linkName) {
        shopByCategory().selectCategory(linkName).click();
        return new ProductPage();
    }

}