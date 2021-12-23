package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 24-12-2021
 */
public class FormAuthenticationPage {

    private WebDriver driver;

    public FormAuthenticationPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement userNameField(){
        return driver.findElement(By.id("username"))
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("password"))
    }

    public WebElement loginBtn () {
        return driver.findElement(By.cssSelector("#login > button"));
    }

    public WebElement flashMessage () {
        return driver.findElement(By.id("flash"));
    }

    public void login(String userName, String password) {
        userNameField().click();
        userNameField().clear();
        userNameField().sendKeys(userName);
        passwordField().click();
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
    }
}