package io.github.mfaisalkhatri.pages.geolocation;

import static io.github.mfaisalkhatri.drivers.DevToolsManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 1/30/2023
 **/
public class MyLocationPage {

    public void OpenBrowserGeoLocationTab () {
        browserGeolocationTab ().click ();
    }

    public void clickOnStartTestBtn () {
        startTestBtn ().click ();
    }

    public String getLatitude () {
        return getDriver ().findElement (By.cssSelector ("td#geo-latitude"))
            .getText ();
    }

    public String getLongitude () {
        return getDriver ().findElement (By.cssSelector ("td#geo-longitude"))
            .getText ();
    }

    private WebElement browserGeolocationTab () {
        return getDriver ().findElement (By.id ("ui-accordion-accordion-header-1"));
    }

    private WebElement startTestBtn () {
        return getDriver ().findElement (By.id ("geo-test"));
    }
}
