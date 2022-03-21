package io.github.mfaisalkhatri.driversetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 21-03-2022
 */
public class DevToolsSetup {

    private static DevTools chromDevTools;
    public ChromeDriver chromeDriver;

    @BeforeSuite
    public void setupClass () {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest () {

//        HashMap<String, Object> chromePrefs = new HashMap<>();
//        // chromePrefs.put("safebrowsing.enabled", "true");
//        chromePrefs.put("download.prompt_for_download", "false");
//        chromePrefs.put("download.default_directory", String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")));

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--window-size=1050,600");
//        //options.addArguments("--headless");
//        options.addArguments("--safebrowsing-disable-download-protection");
//        options.setExperimentalOption("prefs", chromePrefs);
        chromeDriver = new ChromeDriver();
        chromDevTools = chromeDriver.getDevTools();
        chromDevTools.createSession();
        chromDevTools.send(Log.enable());
        chromDevTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("log: " + logEntry.getText());
            System.out.println("level: " + logEntry.getLevel());
        });
//        setupChromeLogs();
        setupBrowser();
    }

    @AfterClass
    public void tearDown () {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    private void setupBrowser () {
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    private void setupChromeLogs () {
        chromDevTools = chromeDriver.getDevTools();
        chromDevTools.createSession();
        chromDevTools.send(Log.enable());
        chromDevTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("log: " + logEntry.getText());
            System.out.println("level: " + logEntry.getLevel());
        });
    }
}