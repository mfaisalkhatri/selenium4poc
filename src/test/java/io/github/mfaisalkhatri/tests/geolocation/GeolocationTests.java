package io.github.mfaisalkhatri.tests.geolocation;

import static io.github.mfaisalkhatri.drivers.DevToolsManager.getDriver;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import io.github.mfaisalkhatri.pages.geolocation.MyLocationPage;
import io.github.mfaisalkhatri.tests.base.DevToolsBaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 1/30/2023
 **/
public class GeolocationTests extends DevToolsBaseSuiteSetup {

    @Test
    public void testGeolocationINBrowser () {
        double latitude = 42.1408845;
        double longitude = -72.5033907;
        Map<String, Object> coordinates = new HashMap<> ();

        coordinates.put ("latitude", latitude);
        coordinates.put ("longitude", longitude);
        coordinates.put ("accuracy", 100);

        getDriver ().executeCdpCommand ("Emulation.setGeolocationOverride", coordinates);

        MyLocationPage locationPage = new MyLocationPage ();

        locationPage.OpenBrowserGeoLocationTab ();
        locationPage.clickOnStartTestBtn ();
        assertEquals (locationPage.getLatitude (), String.valueOf (latitude));
        assertEquals (locationPage.getLongitude (), String.valueOf (longitude));
    }

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "https://mylocation.org/";
        getDriver ().get (websiteLink);
    }

}
