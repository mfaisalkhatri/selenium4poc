package io.github.mfaisalkhatri.tests.retrytests;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 11/2/2022
 **/
public class RetryFailedTests extends BaseSuiteSetup {

    @BeforeClass
    public void setupTests () {
        final String website = "https://ecommerce-playground.lambdatest.io/";
        getDriver ().get (website);
    }

    @Test
    public void testSearchProduct () {

    }

}