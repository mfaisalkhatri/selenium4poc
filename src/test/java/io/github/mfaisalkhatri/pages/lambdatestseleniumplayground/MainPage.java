package io.github.mfaisalkhatri.pages.lambdatestseleniumplayground;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Faisal Khatri
 * @since 11/16/2022
 **/
public class MainPage {

    private final WebDriverWait wait;

    public MainPage () {
        this.wait = new WebDriverWait (getDriver (), Duration.ofSeconds (20));
    }

    public void clickLink (final String linkName) {
        final WebElement link = this.wait.until (ExpectedConditions.elementToBeClickable (By.linkText (linkName)));
        link.click ();
    }

}
