package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created By Faisal Khatri on 28-07-2022
 */
public class OrderSuccessPage {

    public static OrderSuccessPage orderSuccessPage () {
        return new OrderSuccessPage ();
    }

    public void continueToHomePage () {
        continueBtn ().click ();
    }

    public OrderSuccessPage verifySuccessMessage () {
        final WebDriverWait wait = new WebDriverWait (getDriver (), Duration.ofSeconds (20));
        wait.until (
            ExpectedConditions.textToBePresentInElementLocated (By.tagName ("h1"), "Your order has been placed!"));
        assertEquals (getDriver ().findElement (By.tagName ("h1"))
            .getText (), "Your order has been placed!");
        return this;
    }

    private WebElement continueBtn () {
        return getDriver ().findElement (By.cssSelector ("#content > div > a"));
    }
}