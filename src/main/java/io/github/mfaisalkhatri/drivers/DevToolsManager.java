package io.github.mfaisalkhatri.drivers;

import java.util.Objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Builder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.log.Log;

/**
 * Created By Faisal Khatri on 21-03-2022
 */
@Builder
public class DevToolsManager {

    private static final Logger       LOG = LogManager.getLogger ("DevToolsSetup.class");
    private static       ChromeDriver chromeDriver;

    public static void createDriver () {
        final boolean isHeadless = Boolean.parseBoolean (
            Objects.requireNonNullElse (System.getProperty ("headless"), "true"));
        WebDriverManager.chromedriver ()
            .setup ();
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--no-sandbox");
        options.addArguments ("--disable-dev-shm-usage");
        options.addArguments ("--window-size=1050,600");
        if (isHeadless) {
            options.addArguments ("--headless");
        }
        options.addArguments ("--safebrowsing-disable-download-protection");

        chromeDriver = new ChromeDriver (options);
        DevTools chromeDevTools = chromeDriver.getDevTools ();
        chromeDevTools.createSession ();
        chromeDevTools.send (Log.enable ());
        chromeDevTools.addListener (Log.entryAdded (), logEntry -> {
            LOG.error (logEntry.getText ());
            LOG.error (logEntry.getLevel ());
        });
    }

    public static ChromeDriver getDriver () {
        return chromeDriver;
    }

    public static void quitDriver () {
        if (null != chromeDriver) {
            chromeDriver.quit ();
        }
    }
}