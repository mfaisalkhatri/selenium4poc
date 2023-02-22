package io.github.mfaisalkhatri.pages.amazon;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since 2/21/2023
 **/
public class HomePage {

    public String getProductDesc () {
        return getDriver ().findElement (By.cssSelector ("[data-component-id='2'] h2"))
            .getText ();
    }

    public String getProductDescUsingXpath () {
        return getDriver ().findElement (By.xpath ("//*[@data-component-id='2']//h2"))
            .getText ();
    }

    public String getProductPrice () {
        return getDriver ().findElement (By.cssSelector ("[data-component-id=\"2\"] .a-price-whole"))
            .getText ();
    }

    public String getProductPriceUsingXpath () {
        return getDriver ().findElement (
                By.xpath ("//*[@data-component-id=\"2\"]//span[contains(@class,'a-price-whole')]"))
            .getText ();
    }

    public void searchProduct (String product) {

        getDriver ().findElement (By.id ("twotabsearchtextbox"))
            .sendKeys (product);
        getDriver ().findElement (By.id ("nav-search-submit-button"))
            .click ();
    }
}
