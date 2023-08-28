package io.github.mfaisalkhatri.tests.lambdatestecommerce;

import io.github.mfaisalkhatri.data.lambdatestecommerce.BillingData;
import io.github.mfaisalkhatri.data.lambdatestecommerce.TestDataBuilder;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.CheckoutPage.checkoutPage;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.ConfirmOrderPage.confirmOrderPage;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.HomePage.homePage;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.OrderSuccessPage.orderSuccessPage;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class EndToEndWebsiteTests extends BaseSuiteSetup {

    private BillingData billingData;
    private String      unitPriceOfCameraLens;

    @BeforeClass
    public void setupTests () {
        final String website = "https://ecommerce-playground.lambdatest.io/";
        getDriver().get(website);
        this.billingData = TestDataBuilder.getBillingData();
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
        this.unitPriceOfCameraLens = checkoutPage().getUnitPriceOfCameraLens();
        checkoutPage().setBillingAddress(this.billingData)
                .checkoutProduct();
    }

    @Test (dependsOnMethods = "testCheckoutProduct")
    public void testConfirmOrder () {
        confirmOrderPage().verifyPageHeader()
                .verifyProductName()
                .verifyUnitPrice(this.unitPriceOfCameraLens)
                .verifyShippingAddress(this.billingData)
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