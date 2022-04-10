package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement dismissBtn() {
        return driver.findElement(By.cssSelector(".close-dialog"));
    }

    public WebElement accountLink() {
        return driver.findElement(By.id("navbarAccount"));
    }

    public WebElement loginLink() {
        return driver.findElement(By.id("navbarLoginButton"));
    }
}
