package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import org.openqa.selenium.By;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

/**
 * @author Faisal Khatri
 * @since 11/9/2022
 **/
public class LoginPage {

    public String loginBoxTitle () {
        return getDriver ().findElement (By.cssSelector ("div:nth-child(2) > div > div > h2"))
            .getText ();
    }
}


