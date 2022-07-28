package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement logOutLink () {
        return getDriver ().findElement (By.id ("navbarLogoutButton"));
    }

    public void loginIntoJuiceShop (final String email, final String password) {
        enterText (emailField (), email);
        enterText (passwordField (), password);
        loginBtn ().click ();
    }
    
    public WebElement notaCustomerLink () {
        return getDriver ().findElement (By.cssSelector ("#newCustomerLink > a"));
    }

    private WebElement emailField () {
        return getDriver ().findElement (By.name ("email"));
    }

    private WebElement loginBtn () {
        return getDriver ().findElement (By.id ("loginButton"));
    }

    private WebElement passwordField () {
        return getDriver ().findElement (By.id ("password"));
    }

}