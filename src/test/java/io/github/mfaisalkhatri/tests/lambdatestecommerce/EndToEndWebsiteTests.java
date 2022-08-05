package io.github.mfaisalkhatri.tests.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.CheckoutPage.checkoutPage;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.ConfirmOrderPage.confirmOrderPage;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.HomePage.homePage;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.OrderSuccessPage.orderSuccessPage;

import io.github.mfaisalkhatri.data.BillingData;
import io.github.mfaisalkhatri.data.TestDataBuilder;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class EndToEndWebsiteTests extends BaseSuiteSetup {

    private BillingData billingData;
    private String      unitPriceOfCameraLens;

    @BeforeClass
    public void setupTests () {
        final String website = "https://ecommerce-playground.lambdatest.io/";
        getDriver ().get (website);
        billingData = TestDataBuilder.getBillingData ();
    }

    @Test (dependsOnMethods = "testRegisterUser")
    public void testAddProductToCart () {
        homePage ().shopByCategory ("Components")
            .addPalmTreoCameraLensToCart ()
            .verifySuccessMessage ()
            .checkoutProduct ();
    }

    @Test (dependsOnMethods = "testAddProductToCart")
    public void testCheckoutProduct () {
        unitPriceOfCameraLens = checkoutPage ().getUnitPriceOfCameraLens ();
        checkoutPage ().setBillingAddress (billingData)
            .checkoutProduct ();
    }

    @Test (dependsOnMethods = "testCheckoutProduct")
    public void testConfirmOrder () {
        confirmOrderPage ().verifyPageHeader ()
            .verifyProductName ()
            .verifyUnitPrice (unitPriceOfCameraLens)
            .verifyShippingAddress (billingData)
            .confirmOrder ();
    }

    @Test (dependsOnMethods = "testConfirmOrder")
    public void testOrderSuccess () {
        orderSuccessPage ().verifySuccessMessage ()
            .continueToHomePage ();
    }

    @Test
    public void testRegisterUser () {
        homePage ().openUserRegistrationPage ()
            .verifyPageHeader ()
            .registerUser ()
            .verifySuccessfulRegistration ()
            .continueToMyAccount ()
            .verifyPageHeader ();
    }
}