package io.github.mfaisalkhatri.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

public class MultipleWindowsPage {

    private final WebDriverWait wait;

    public MultipleWindowsPage () {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public WebElement pageHeader () {
        return getDriver().findElement(By.tagName("h3"));
    }

    public WebElement link (String text) {
        return getDriver().findElement(By.linkText(text));
    }

    public void openLinkInNewWindow (String linkText) {
        String originalWindow = getDriver().getWindowHandle();
        link(linkText).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public boolean checkNewWindowTitle (String newWindowTitle) {
        return wait.until(ExpectedConditions.titleIs(newWindowTitle));
    }
}