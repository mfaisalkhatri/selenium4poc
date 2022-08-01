package io.github.mfaisalkhatri.drivers;

import static org.openqa.selenium.remote.Browser.CHROME;
import static org.openqa.selenium.remote.Browser.EDGE;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.mfaisalkhatri.enums.Browsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
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

    public static void createDriver (Browsers browser) {
        switch (browser) {
            case FIREFOX:
                setupFirefoxDriver ();
                break;
            case EDGE:
                setupEdgeDriver ();
                break;
            case OPERA:
                setupOperaDriver ();
                break;
            case REMOTE_CHROME:
                setupRemoteChrome ();
                break;
            case REMOTE_FIREFOX:
                setupRemoteFirefox ();
                break;
            case REMOTE_EDGE:
                setupRemoteEdge ();
                break;
            case CHROME:
            default:
                setupChromeDriver ();
        }
        setupBrowserTimeouts ();
    }

    public static <D extends WebDriver> D getDriver () {
        return (D) DriverManager.DRIVER.get ();
    }

    private static void setDriver (WebDriver driver) {
        DriverManager.DRIVER.set (driver);
    }

    public static void quitDriver () {
        if (null != DRIVER.get ()) {
            LOG.info ("Closing the driver...");
            getDriver ().quit ();
            DRIVER.remove ();
        }
    }

    private static void setupBrowserTimeouts () {
        LOG.info ("Setting Browser Timeouts....");
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

    private DriverManager () {
    }

    private static void setupFirefoxDriver () {
        LOG.info ("Setting up Firefox Driver....");
        final FirefoxOptions options = new FirefoxOptions ();
        options.addArguments ("--no-sandbox");
        options.addArguments ("--disable-dev-shm-usage");
        options.addArguments ("--window-size=1050,600");
        options.addArguments ("--headless");
        setDriver (WebDriverManager.firefoxdriver ()
            .capabilities (options)
            .create ());
        LOG.info ("Firefox Driver created successfully!");
    }

    private static void setupEdgeDriver () {
        LOG.info ("Setting up Edge Driver....");
        setDriver (WebDriverManager.edgedriver ()
            .create ());
        LOG.info ("Edge Driver created successfully!");
    }

    private static void setupOperaDriver () {
        LOG.info ("Setting up Opera Driver....");
        setDriver (WebDriverManager.operadriver ()
            .create ());
        LOG.info ("Opera Driver created successfully!");
    }

    private static void setupChromeDriver () {
        LOG.info ("Setting up Chrome Driver....");
        boolean isHeadless = Boolean.parseBoolean (
            Objects.requireNonNullElse (System.getProperty ("headless"), "true"));
        final HashMap<String, Object> chromePrefs = new HashMap<> ();
        chromePrefs.put ("safebrowsing.enabled", "true");
        chromePrefs.put ("download.prompt_for_download", "false");
        chromePrefs.put ("download.default_directory",
            String.valueOf (Paths.get (System.getProperty ("user.home"), "Downloads")));

        final ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--no-sandbox");
        options.addArguments ("--disable-dev-shm-usage");
        options.addArguments ("--window-size=1050,600");
        if (isHeadless) {
            options.addArguments ("--headless");
        }
        options.addArguments ("--safebrowsing-disable-download-protection");
        options.setExperimentalOption ("prefs", chromePrefs);

        setDriver (WebDriverManager.chromedriver ()
            .capabilities (options)
            .create ());
        LOG.info ("Chrome Driver created successfully!");
    }

    private static void setupRemoteChrome () {
        try {
            LOG.info ("Setting up Remote Chrome Driver....");
            final DesiredCapabilities caps = new DesiredCapabilities ();
            caps.setBrowserName (CHROME.browserName ());
            setDriver (new RemoteWebDriver (new URL (HUB_URL), caps));
            LOG.info ("Remote Chrome Driver created successfully!");
        } catch (final MalformedURLException e) {
            LOG.error ("Error setting remote_chrome", e);
        }
    }

    private static void setupRemoteFirefox () {
        try {

            LOG.info ("Setting up Remote Firefox Driver....");
            final DesiredCapabilities caps = new DesiredCapabilities ();
            caps.setBrowserName ("firefox");
            setDriver (new RemoteWebDriver (new URL (HUB_URL), caps));
            LOG.info ("Remote Firefox Driver created successfully!");
        } catch (final MalformedURLException e) {
            LOG.error ("Error setting remote_firefox", e);
        }
    }

    private static void setupRemoteEdge () {
        try {
            LOG.info ("Setting up Remote Edge Driver....");
            final DesiredCapabilities caps = new DesiredCapabilities ();
            caps.setBrowserName ("MicrosoftEdge");
            setDriver (new RemoteWebDriver (new URL (HUB_URL), caps));
            LOG.info ("Remote Edge Driver created successfully!");
        } catch (final MalformedURLException e) {
            LOG.error ("Error setting remote_edge", e);
        }
    }
}