package io.github.mfaisalkhatri.pages.juiceshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;

public class LoginPage {


    public WebElement notaCustomerLink () {
        return getDriver().findElement(By.cssSelector("#newCustomerLink > a"));
    }

    private WebElement emailField () {
        return getDriver().findElement(By.name("email"));
    }

    private WebElement passwordField () {
        return getDriver().findElement(By.id("password"));
    }

    private WebElement loginBtn () {
        return getDriver().findElement(By.id("loginButton"));
    }

    public WebElement logOutLink () {
        return getDriver().findElement(By.id("navbarLogoutButton"));
    }

    public void loginIntoJuiceShop (String email, String password) {
        enterText(emailField(), email);
        enterText(passwordField(), password);
        loginBtn().click();
    }

}