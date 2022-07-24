package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    private final Helper helper;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        helper = new Helper();
    }

    public WebElement notaCustomerLink () {
        return driver.findElement(By.cssSelector("#newCustomerLink > a"));
    }

    private WebElement emailField () {
        return driver.findElement(By.name("email"));
    }

    private WebElement passwordField () {
        return driver.findElement(By.id("password"));
    }

    private WebElement loginBtn () {
        return driver.findElement(By.id("loginButton"));
    }

    public WebElement logOutLink () {
        return driver.findElement(By.id("navbarLogoutButton"));
    }

    public void loginIntoJuiceShop (String email, String password) {
        helper.enterText(emailField(), email);
        helper.enterText(passwordField(), password);
        loginBtn().click();
    }

}