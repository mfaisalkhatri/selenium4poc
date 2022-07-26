package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 26-07-2022
 */
public class ProductPage {
    private WebElement palmTreoCameraLens () {
        return getDriver().findElement(By.cssSelector("#entry_212408 > div > div:nth-child(2)"));
    }

    private WebElement addToCartBtn () {
        return getDriver().findElement(By.cssSelector("div.product-action > button.btn.btn-cart.cart-29"));
    }

    private WebElement notificationPopUp () {
        return getDriver().findElement(By.id("notification-box-top"));
    }

    public ProductPage verifySuccessMessage () {
        assertEquals(notificationPopUp().findElement(By.tagName("p")).getText(), "Success: You have added Palm Treo Pro to your shopping cart!");
        return this;
    }

    private WebElement checkoutBtn () {
        return notificationPopUp().findElement(By.cssSelector("div.form-row > div:nth-child(2) > a"));
    }

    public String getpriceOfPalmTreoPro () {
        return getDriver().findElement(By.cssSelector("div:nth-child(2) > div > div.caption > div > span")).getText();
    }

    public ProductPage addProductToCart () {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(palmTreoCameraLens()).moveToElement(addToCartBtn()).perform();
        return this;
    }

    public CheckoutPage checkoutProduct () {
        checkoutBtn().click();
        return new CheckoutPage();
    }
}