package io.github.mfaisalkhatri.automationpractice;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.opera.*;
import org.testng.annotations.*;

import java.time.*;

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
            setupBrowser();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            setupBrowser();

        } else if (browser.equalsIgnoreCase("opera")) {
            driver = new OperaDriver();
            setupBrowser();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            setupBrowser();
        } else {
            System.out.println("Browser value is not defined correctly! It should be either chrome, firefox, edge or opera!");
        }
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

    private void setupBrowser () {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

    }
}