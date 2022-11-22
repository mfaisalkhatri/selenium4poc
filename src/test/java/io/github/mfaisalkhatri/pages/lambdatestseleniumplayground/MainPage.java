package io.github.mfaisalkhatri.pages.lambdatestseleniumplayground;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 11/16/2022
 **/
public class MainPage {

    public void clickLink (final String linkName) {
        final WebElement link = getDriver ().findElement (By.linkText (linkName));
        link.click ();
    }

}
