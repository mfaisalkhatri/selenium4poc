package io.github.mfaisalkhatri.pages.theinternet;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MultipleWindowsPage {

    private final DriverManager driverManager;
    private final WebDriverWait wait;

    public MultipleWindowsPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10));
    }

    public WebElement pageHeader () {
        return driverManager.getDriver().findElement(By.tagName("h3"));
    }

    public WebElement link (String text) {
        return driverManager.getDriver().findElement(By.linkText(text));
    }

    public void openLinkInNewWindow (String linkText) {
        String originalWindow = driverManager.getDriver().getWindowHandle();
        link(linkText).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driverManager.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driverManager.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public boolean checkNewWindowTitle (String newWindowTitle) {
        return wait.until(ExpectedConditions.titleIs(newWindowTitle));
    }
}