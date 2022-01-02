package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 02-01-2022
 */
public class IFramePage {

    private WebDriver driver;

    public IFramePage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement iFrame () {
        return driver.findElement(By.id("mce_0_ifr"));
    }

    public void switchToiFrame () {
        driver.switchTo().frame(iFrame());
    }

    public WebElement textArea () {
        return driver.findElement(By.id("tinymce"));
    }

    public String getTextValue () {
        return driver.findElement(By.cssSelector("#tinymce > p")).getText();
    }

    public void enterTextInIFrame (String text) {
        textArea().click();
        textArea().clear();
        textArea().sendKeys(text);
    }
}