package io.github.mfaisalkhatri.driversetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class Setup {

    public WebDriver driver;


    @BeforeSuite
    public void setupClass () {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.operadriver().setup();
    }

    @Parameters("browser")
    @BeforeClass
    public void setupTest (String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            // FirefoxOptions options = new FirefoxOptions();
            // options.addArguments("--websocket-port", "4444");
            //driver = new FirefoxDriver(options);
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else {
            // FIXME: Throw an Error here.
            System.out.println("Browser value is not defined correctly! It should be either chrome, firefox, edge or opera!");
        }
        setupBrowser();
    }

    @AfterClass
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

    private void setupBrowser () {
        driver.manage().window().maximize();    // FIXME: Maximize does not work in Linux
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }
}