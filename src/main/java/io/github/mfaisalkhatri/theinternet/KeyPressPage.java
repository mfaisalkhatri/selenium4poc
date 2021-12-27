package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class KeyPressPage {

    private WebDriver driver;

    public KeyPressPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement textBox () {
        return driver.findElement(By.id("target"));
    }

    public  WebElement result () {
        return driver.findElement(By.id("result"));
    }

    public void pressKeys (Keys keys) {
        textBox().sendKeys(keys);
    }

    public String resultText () {
        return result().getText();
    }
}
