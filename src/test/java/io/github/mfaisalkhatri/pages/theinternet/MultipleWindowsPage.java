package io.github.mfaisalkhatri.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MultipleWindowsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MultipleWindowsPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement pageHeader () {
        return driver.findElement(By.tagName("h3"));
    }

    public WebElement link (String text) {
        return driver.findElement(By.linkText(text));
    }

    public void openLinkInNewWindow (String linkText) {
        String originalWindow = driver.getWindowHandle();
        link(linkText).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public boolean checkNewWindowTitle (String newWindowTitle) {
        return wait.until(ExpectedConditions.titleIs(newWindowTitle));
    }
}