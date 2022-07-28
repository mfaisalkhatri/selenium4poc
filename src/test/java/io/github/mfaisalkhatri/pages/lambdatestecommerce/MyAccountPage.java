package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class MyAccountPage {

    public MyAccountPage verifyPageHeader () {
        assertEquals (getDriver ().findElement (By.tagName ("h2"))
            .getText (), "My Account");
        return this;
    }
}