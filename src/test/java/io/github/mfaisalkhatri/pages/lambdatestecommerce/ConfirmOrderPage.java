package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;

import io.github.mfaisalkhatri.data.BillingData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created By Faisal Khatri on 28-07-2022
 */
public class ConfirmOrderPage {

    public static ConfirmOrderPage confirmOrderPage () {
        return new ConfirmOrderPage ();
    }

    public OrderSuccessPage confirmOrder () {
        confirmOrderBtn ().click ();
        return new OrderSuccessPage ();
    }

    public ConfirmOrderPage verifyPageHeader () {
        final WebDriverWait wait = new WebDriverWait (getDriver (), Duration.ofSeconds (10));
        assertEquals (wait.until (ExpectedConditions.visibilityOfElementLocated (By.tagName ("h1")))
            .getText (), "Confirm Order");
        return this;
    }

    public ConfirmOrderPage verifyProductName () {
        assertEquals (getDriver ().findElement (
                By.cssSelector ("#content > div.table-responsive > table > tbody > tr > td:nth-child(1)"))
            .getText (), "Palm Treo Pro");
        return this;
    }

    public ConfirmOrderPage verifyShippingAddress (final BillingData billingData) {
        final String expectedMessage = "{0} {1}\n{2}\n{3} {4}\n{5},{6}";
        assertEquals (getDriver ().findElement (By.cssSelector ("#content > div.row > div:nth-child(2) > div > div"))
            .getText (), MessageFormat.format (expectedMessage, billingData.getFirstName (), billingData.getLastName (),
            billingData.getAddressLineOne (), billingData.getCity (), billingData.getPostCode (),
            billingData.getState (), billingData.getCountry ()));

        return this;
    }

    public ConfirmOrderPage verifyUnitPrice (final String unitPrice) {
        assertEquals (getDriver ().findElement (
                By.cssSelector ("#content > div.table-responsive > table > tbody > tr > td:nth-child(4)"))
            .getText (), unitPrice);
        return this;
    }

    private WebElement confirmOrderBtn () {
        return getDriver ().findElement (By.id ("button-confirm"));
    }

}