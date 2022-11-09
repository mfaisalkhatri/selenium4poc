package io.github.mfaisalkhatri.tests.retrytests;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.listeners.Retry;
import io.github.mfaisalkhatri.pages.lambdatestecommerce.HomePage;
import io.github.mfaisalkhatri.pages.lambdatestecommerce.LoginPage;
import io.github.mfaisalkhatri.pages.lambdatestecommerce.SearchResultPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 11/2/2022
 **/
public class RetryFailedTests extends BaseSuiteSetup {

    private HomePage homePage;

    @BeforeClass
    public void setupTests () {
        final String website = "https://ecommerce-playground.lambdatest.io/";
        getDriver ().get (website);
        this.homePage = new HomePage ();
    }

    @Test (retryAnalyzer = Retry.class)
    public void testNavigationToLoginPage () {
        final LoginPage loginPage = this.homePage.navigateToLoginPage ();
        assertEquals (loginPage.loginBoxTitle (), "Returning Customers");
    }

    @Test
    public void testSearchProduct () {
        final String productName = "Canon EOS 5D";
        final SearchResultPage searchResultPage = this.homePage.searchProduct (productName);
        assertEquals (searchResultPage.pageHeader (), "Search - " + productName);
        assertEquals (searchResultPage.getFirstSearchResultText (), "Canon eos 5D");
    }

}