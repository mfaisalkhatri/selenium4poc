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

    public WebElement myAccountLink () {
        return getDriver().findElement(By.linkText("My account"));
    }

    public WebElement loginLink () {
        return getDriver().findElement(By.linkText("Login"));
    }

    public WebElement registerLink () {
        return getDriver().findElement(By.linkText("Register"));
    }

    public WebElement shopByCategoryLink () {
        return getDriver().findElement(By.linkText("Shop by Category"));
    }

    public WebElement selectCategory (String linkName) {
        return getDriver().findElement(By.linkText(linkName));
    }

    public RegistrationPage openUserRegistrationPage () {
        myAccountLink().click();
        registerLink().click();
        return new RegistrationPage();
    }

//    public ProductPage shopByCategory (String linkName) {
//        selectCategory(linkName).click();
//        return new ProductPage(driverManager);
//    }

}