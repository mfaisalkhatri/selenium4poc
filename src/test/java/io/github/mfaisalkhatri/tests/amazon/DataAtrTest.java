package io.github.mfaisalkhatri.tests.amazon;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import io.github.mfaisalkhatri.pages.amazon.HomePage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 2/21/2023
 **/
public class DataAtrTest extends BaseSuiteSetup {

    @BeforeClass
    public void setupTest () {
        getDriver ().navigate ()
            .to ("https://www.amazon.in/");
    }

    @Test
    public void testDataAttr () {
        HomePage homePage = new HomePage ();
        homePage.searchProduct ("Mobile Phone");

        System.out.println (homePage.getProductDesc ());
        System.out.println (homePage.getProductPrice ());
        System.out.println (homePage.getProductDescUsingXpath ());
        System.out.println (homePage.getProductPriceUsingXpath ());
    }
}
