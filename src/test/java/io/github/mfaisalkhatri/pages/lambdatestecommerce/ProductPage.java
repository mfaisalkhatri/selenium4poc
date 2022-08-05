package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 26-07-2022
 */
public class ProductPage {

    public static ProductPage productPage () {
        return new ProductPage ();
    }

    public ProductPage addPalmTreoCameraLensToCart () {
        final Actions actions = new Actions (getDriver ());
        actions.moveToElement (palmTreoCameraLens ())
            .pause (500)
            .moveToElement (addToCartBtn ())
            .pause (200)
            .click ()
            .perform ();
        return this;
    }

    public CheckoutPage checkoutProduct () {
        checkoutBtn ().click ();
        return CheckoutPage.checkoutPage ();
    }

    public ProductPage verifySuccessMessage () {
        assertEquals (notificationPopUp ().findElement (By.tagName ("p"))
            .getText (), "Success: You have added\n" + "Palm Treo Pro\n" + "to your\n" + "shopping cart\n" + "!");
        return this;
    }

    private WebElement addToCartBtn () {
        return getDriver ().findElement (By.cssSelector ("div.product-action > button.btn.btn-cart.cart-29"));
    }

    private WebElement checkoutBtn () {
        return notificationPopUp ().findElement (By.cssSelector ("div.form-row > div:nth-child(2) > a"));
    }

    private WebElement notificationPopUp () {
        return getDriver ().findElement (By.id ("notification-box-top"));
    }

    private WebElement palmTreoCameraLens () {
        return getDriver ().findElement (By.cssSelector ("#entry_212408 > div > div:nth-child(2)"));
    }
}