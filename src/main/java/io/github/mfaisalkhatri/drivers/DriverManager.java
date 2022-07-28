package io.github.mfaisalkhatri.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Faisal Khatri
 * @since 24/07/2022
 */
public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER  = new ThreadLocal<> ();
    private static final String                 HUB_URL = "http://localhost:4444/wd/hub";
    private static final Logger                 LOG     = LogManager.getLogger ("DriverManager.class");

    public static void createDriver (final String browser) {
        if (browser.equalsIgnoreCase ("firefox")) {
            final FirefoxOptions options = new FirefoxOptions ();
            options.addArguments ("--no-sandbox");
            options.addArguments ("--disable-dev-shm-usage");
            options.addArguments ("--window-size=1050,600");
            options.addArguments ("--headless");

            DRIVER.set (WebDriverManager.firefoxdriver ()
                .capabilities (options)
                .create ());

        } else if (browser.equalsIgnoreCase ("edge")) {

            DRIVER.set (WebDriverManager.edgedriver ()
                .create ());

        } else if (browser.equalsIgnoreCase ("opera")) {

            DRIVER.set (WebDriverManager.operadriver ()
                .create ());

        } else if (browser.equalsIgnoreCase ("chrome")) {

            final HashMap<String, Object> chromePrefs = new HashMap<> ();
            chromePrefs.put ("safebrowsing.enabled", "true");
            chromePrefs.put ("download.prompt_for_download", "false");
            chromePrefs.put ("download.default_directory",
                String.valueOf (Paths.get (System.getProperty ("user.home"), "Downloads")));

            final ChromeOptions options = new ChromeOptions ();
            options.addArguments ("--no-sandbox");
            options.addArguments ("--disable-dev-shm-usage");
            options.addArguments ("--window-size=1050,600");
            options.addArguments ("--headless");
            options.addArguments ("--safebrowsing-disable-download-protection");
            options.setExperimentalOption ("prefs", chromePrefs);

            DRIVER.set (WebDriverManager.chromedriver ()
                .capabilities (options)
                .create ());

        } else if (browser.equalsIgnoreCase ("remote-chrome")) {
            try {
                final DesiredCapabilities caps = new DesiredCapabilities ();
                caps.setBrowserName (Browser.CHROME.browserName ());
                caps.setVersion ("101");
                DRIVER.set (new RemoteWebDriver (new URL (HUB_URL), caps));
            } catch (final MalformedURLException e) {
                LOG.error ("Error setting remote-chrome", e);
            }
        } else if (browser.equalsIgnoreCase ("remote-firefox")) {
            try {
                final DesiredCapabilities caps = new DesiredCapabilities ();
                caps.setBrowserName (Browser.FIREFOX.browserName ());
                caps.setVersion ("99");
                DRIVER.set (new RemoteWebDriver (new URL (HUB_URL), caps));
            } catch (final MalformedURLException e) {
                LOG.error ("Error setting remote-firefox", e);
            }
        } else if (browser.equalsIgnoreCase ("remote-edge")) {
            try {
                final DesiredCapabilities caps = new DesiredCapabilities ();
                caps.setBrowserName (Browser.EDGE.browserName ());
                caps.setVersion ("100");
                DRIVER.set (new RemoteWebDriver (new URL (HUB_URL), caps));
            } catch (final MalformedURLException e) {
                LOG.error ("Error setting remote-edge", e);
            }
        } else {
            LOG.error ("Browser value is not defined correctly! It should be either chrome, firefox, edge or opera!");
        }
        setupBrowserTimeouts ();
    }

    public static <D extends WebDriver> D getDriver () {
        return (D) DriverManager.DRIVER.get ();
    }

    public static void quitDriver () {
        if (null != DRIVER.get ()) {
            LOG.info ("Closing the driver...");
            getDriver ().quit ();
            DRIVER.remove ();
        }
    }

    private static void setupBrowserTimeouts () {
        getDriver ().manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
        getDriver ().manage ()
            .timeouts ()
            .pageLoadTimeout (Duration.ofSeconds (30));
        getDriver ().manage ()
            .timeouts ()
            .scriptTimeout (Duration.ofSeconds (30));
    }
}