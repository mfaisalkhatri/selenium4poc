package io.github.mfaisalkhatri.juiceshop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    private final WebDriver driver;


    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
