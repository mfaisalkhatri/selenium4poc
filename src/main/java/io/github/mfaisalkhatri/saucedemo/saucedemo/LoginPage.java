package io.github.mfaisalkhatri.saucedemo.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class LoginPage {

    WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    private WebElement username () {
        return driver.findElement(By.id("user-name"));
    }

    private WebElement password () {
        return driver.findElement(with(By.tagName("input")).below(username()));

    }

    private WebElement loginBtn () {
        return driver.findElement(with(By.tagName("input")).below(password()));
    }

    public void websiteLogin(String userName, String pswd) {
        username().click();
        username().clear();
        username().sendKeys(userName);
        password().click();
        password().clear();
        password().sendKeys(pswd);
        loginBtn().click();

    }

}