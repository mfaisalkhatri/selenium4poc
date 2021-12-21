package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created By Faisal Khatri on 21-12-2021
 */
public class CheckboxPage {

    private WebDriver driver;

    public CheckboxPage (WebDriver driver) {
        this.driver = driver;
    }

    public String pageHeader () {
        return driver.findElement(By.tagName("h3")).getText();
    }

    public List<WebElement> checkboxes () {
        List<WebElement> cboxes = driver.findElements(By.cssSelector("#checkboxes > input[type=checkbox]"));
        return cboxes;
    }

    public WebElement checkboxOne () {
        return checkboxes().get(0);
    }

    public WebElement checkboxTwo () {
        return checkboxes().get(1);
    }
}