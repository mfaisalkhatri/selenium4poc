package io.github.mfaisalkhatri.pages.juiceshop;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    public WebElement accountLink () {
        return getDriver ().findElement (By.id ("navbarAccount"));
    }

    public void openLoginPage () {
        final Actions action = new Actions (getDriver ());
        meWantThisLink ().click ();
        action.pause (Duration.ofSeconds (5))
            .moveToElement (dismissBtn ())
            .click ()
            .build ()
            .perform ();
        accountLink ().click ();
        loginLink ().click ();
    }

    public String yourBasketCount () {
        return getDriver ().findElement (By.cssSelector (".fa-layers-counter"))
            .getText ();
    }

    public WebElement yourBasketLink () {
        return getDriver ().findElement (By.cssSelector ("button.mat-focus-indicator:nth-child(7)"));
    }

    private WebElement dismissBtn () {
        return getDriver ().findElement (By.cssSelector (".close-dialog"));
    }
    
    private WebElement loginLink () {
        return getDriver ().findElement (By.id ("navbarLoginButton"));
    }

    private WebElement meWantThisLink () {
        return getDriver ().findElement (By.cssSelector (".cc-btn"));
    }

}