package io.github.mfaisalkhatri.automationpractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement signInBtn() {
        return driver.findElement(By.className("login"));
    }
    public WebElement contactUsLink() {
        return driver.findElement(with(By.tagName("a")).toLeftOf(signInBtn()));
    }

    private void takeScreenShot () {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}