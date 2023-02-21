package io.github.mfaisalkhatri.drivers;

import static java.text.MessageFormat.format;
import static org.openqa.selenium.remote.Browser.CHROME;

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
    private static final ThreadLocal<WebDriver> DRIVER          = new ThreadLocal<> ();
    private static final String                 GRID_URL        = "@hub.lambdatest.com/wd/hub";
    private static final String                 HUB_URL         = "http://localhost:4444/wd/hub";
    private static final Logger                 LOG             = LogManager.getLogger ("DriverManager.class");
    private static final String                 LT_ACCESS_TOKEN = System.getProperty ("LT_ACCESS_KEY");
    private static final String                 LT_USERNAME     = System.getProperty ("LT_USERNAME");

    public static void createDriver (final Browsers browser) {
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
            case REMOTE_CHROME_LAMBDATEST:
                setupChromeInLambdaTest ();
                break;
            case REMOTE_FIREFOX_LAMBDATEST:
                setupFirefoxInLambdaTest ();
                break;
            case CHROME:
            default:
                setupChromeDriver ();
        }
        setupBrowserTimeouts ();
    }

    public static WebDriver getDriver () {
        return DriverManager.DRIVER.get ();
    }

    public static void quitDriver () {
        if (null != DRIVER.get ()) {
            LOG.info ("Closing the driver...");
            getDriver ().quit ();
            DRIVER.remove ();
        }
    }

    private static HashMap<String, Object> ltOptions () {
        final HashMap<String, Object> ltOptions = new HashMap<> ();
        ltOptions.put ("username", LT_USERNAME);
        ltOptions.put ("accessKey", LT_ACCESS_TOKEN);
        ltOptions.put ("resolution", "2560x1440");
        ltOptions.put ("selenium_version", "4.0.0");
        ltOptions.put ("build", "LambdaTest Playground Build");
        ltOptions.put ("name", "LambdaTest Playground Tests");
        ltOptions.put ("w3c", true);
        ltOptions.put ("plugin", "java-testNG");
        return ltOptions;
    }

    private static void setDriver (final WebDriver driver) {
        DriverManager.DRIVER.set (driver);
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

    private static void setupChromeDriver () {
        LOG.info ("Setting up Chrome Driver....");
        final boolean isHeadless = Boolean.parseBoolean (
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

    private static void setupChromeInLambdaTest () {
        final ChromeOptions browserOptions = new ChromeOptions ();
        browserOptions.setPlatformName ("Windows 10");
        browserOptions.setBrowserVersion ("108.0");
        browserOptions.setCapability ("LT:Options", ltOptions ());
        try {
            setDriver (
                new RemoteWebDriver (new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_TOKEN, GRID_URL)),
                    browserOptions));
        } catch (final MalformedURLException e) {
            LOG.error ("Error setting up cloud browser in LambdaTest", e);
        }

    }

    private static void setupEdgeDriver () {
        LOG.info ("Setting up Edge Driver....");
        setDriver (WebDriverManager.edgedriver ()
            .create ());
        LOG.info ("Edge Driver created successfully!");
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

    private static void setupFirefoxInLambdaTest () {
        final FirefoxOptions browserOptions = new FirefoxOptions ();
        browserOptions.setPlatformName ("Windows 10");
        browserOptions.setBrowserVersion ("108.0");
        browserOptions.setCapability ("LT:Options", ltOptions ());
        try {
            setDriver (
                new RemoteWebDriver (new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_TOKEN, GRID_URL)),
                    browserOptions));
        } catch (final MalformedURLException e) {
            LOG.error ("Error setting up firefox  browser in LambdaTest", e);
        }

    }

    private static void setupOperaDriver () {
        LOG.info ("Setting up Opera Driver....");
        setDriver (WebDriverManager.operadriver ()
            .create ());
        LOG.info ("Opera Driver created successfully!");

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

    private DriverManager () {
    }
}