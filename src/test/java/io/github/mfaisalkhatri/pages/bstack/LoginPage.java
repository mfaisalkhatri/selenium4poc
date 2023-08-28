package io.github.mfaisalkhatri.pages.bstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

/**
 * @author Faisal Khatri
 * @since 12/27/2022
 **/
public class LoginPage {

    public String getPasswordText () {
        return getDriver ().findElement (By.id ("password"))
            .getText ();
    }

    public void openPasswordDropdown () {
        final WebElement dropdown = getDriver ().findElement (By.cssSelector ("#password > div > div.css-1wy0on6 > div"));
        dropdown.click ();

    }

    public void selectAutofillPasswordText () {
        final WebElement autoFillPasswordValue = getDriver ().findElement (By.cssSelector (
            "#password > div.css-26l3qy-menu > div > div > div:nth-child(2) #react-select-3-option-0-0"));
        autoFillPasswordValue.click ();
    }

}
