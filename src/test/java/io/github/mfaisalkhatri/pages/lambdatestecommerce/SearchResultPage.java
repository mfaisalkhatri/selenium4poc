package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since 11/9/2022
 **/
public class SearchResultPage {

    public String getFirstSearchResultText () {
        return getDriver ().findElement (By.cssSelector ("div:nth-child(1) > div > div.caption > h4"))
            .getText ();
    }

    public String pageHeader () {
        return getDriver ().findElement (By.cssSelector ("#product-search h1"))
            .getText ();
    }

}
