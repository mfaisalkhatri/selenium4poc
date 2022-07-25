package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final DriverManager driverManager;
    private final Helper helper;

    public LoginPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        helper = new Helper();
    }

    public WebElement notaCustomerLink () {
        return driverManager.getDriver().findElement(By.cssSelector("#newCustomerLink > a"));
    }

    private WebElement emailField () {
        return driverManager.getDriver().findElement(By.name("email"));
    }

    private WebElement passwordField () {
        return driverManager.getDriver().findElement(By.id("password"));
    }

    private WebElement loginBtn () {
        return driverManager.getDriver().findElement(By.id("loginButton"));
    }

    public WebElement logOutLink () {
        return driverManager.getDriver().findElement(By.id("navbarLogoutButton"));
    }

    public void loginIntoJuiceShop (String email, String password) {
        helper.enterText(emailField(), email);
        helper.enterText(passwordField(), password);
        loginBtn().click();
    }

}