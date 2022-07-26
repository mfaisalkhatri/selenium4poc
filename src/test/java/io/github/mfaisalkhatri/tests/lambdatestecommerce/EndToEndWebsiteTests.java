package io.github.mfaisalkhatri.tests.lambdatestecommerce;

import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.HomePage.homePage;
import static io.github.mfaisalkhatri.pages.lambdatestecommerce.ProductPage.productPage;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class EndToEndWebsiteTests extends BaseSuiteSetup {

    private String unitPriceOfCameraLens;

    @BeforeClass
    public void setupTests () {
        final String website = "https://ecommerce-playground.lambdatest.io/";
        getDriver().get(website);
    }

    @Test
    public void testRegisterUser () {
        homePage().openUserRegistrationPage()
                .verifyPageHeader()
                .registerUser()
                .verifySuccessfulRegistration()
                .continueToMyAccount()
                .verifyPageHeader();
    }

    @Test
    public void testAddProductToCart () {
        unitPriceOfCameraLens = homePage()
                .shopByCategory("Components")
                .getpriceOfPalmTreoProLens();
        
        productPage()
                .addPalmTreoCameraLensToCart()
                .verifySuccessMessage()
                .checkoutProduct();
    }
}