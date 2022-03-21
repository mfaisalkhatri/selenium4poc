package io.github.mfaisalkhatri.devtools;

import io.github.mfaisalkhatri.driversetup.DevToolsSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 21-03-2022
 */
public class LogTest extends DevToolsSetup {

    @Test
    public void checkChromeLogs () {
        chromeDriver.get("https://www.google.co.in");
        WebElement searchbox = chromeDriver.findElement(By.name("q"));
        searchbox.click();
        searchbox.sendKeys("Apple iphone 13 Pro");
        WebElement submitBtn = chromeDriver.findElement(By.name("btnK"));
        submitBtn.click();
    }
}