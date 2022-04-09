package io.github.mfaisalkhatri.driversetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created By Faisal Khatri on 21-03-2022
 */
public class DevToolsSetup {

    private static final Logger log = LogManager.getLogger("DevToolsSetup.class");
    private static DevTools chromDevTools;
    public ChromeDriver chromeDriver;

    @BeforeClass
    public void setupTest () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1050,600");
        options.addArguments("--headless");
        options.addArguments("--safebrowsing-disable-download-protection");

        chromeDriver = new ChromeDriver(options);
        chromDevTools = chromeDriver.getDevTools();
        chromDevTools.createSession();
        chromDevTools.send(Log.enable());
        chromDevTools.addListener(Log.entryAdded(), logEntry -> {
            log.error(logEntry.getText());
            log.error(logEntry.getLevel());
        });
    }

    @AfterClass
    public void tearDown () {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }
}