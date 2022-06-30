/*      Copyright 2022 Mohammad Faisal Khatri

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package io.github.mfaisalkhatri.driversetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class Setup {

    private static final Logger LOG = LogManager.getLogger("Setup.class");
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver () {
        return DRIVER.get();
    }

//    @BeforeSuite
//    public void setupClass () {
//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.operadriver().setup();
//    }

    @Parameters("browser")
    @BeforeClass
    public void setupTest (String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            // FirefoxOptions options = new FirefoxOptions();
            // options.addArguments("--websocket-port", "4444");
            //DRIVER = new FirefoxDriver(options);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1050,600");
            options.addArguments("--headless");

            //  DRIVER.set(new FirefoxDriver(options));
            DRIVER.set(WebDriverManager.firefoxdriver().capabilities(options).create());

        } else if (browser.equalsIgnoreCase("edge")) {
            //DRIVER.set(new EdgeDriver());
            DRIVER.set(WebDriverManager.edgedriver().create());
        } else if (browser.equalsIgnoreCase("opera")) {
            //DRIVER.set(new OperaDriver());
            DRIVER.set(WebDriverManager.operadriver().create());
        } else if (browser.equalsIgnoreCase("chrome")) {

            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("safebrowsing.enabled", "true");
            chromePrefs.put("download.prompt_for_download", "false");
            chromePrefs.put("download.default_directory", String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")));

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1050,600");
            options.addArguments("--headless");
            options.addArguments("--safebrowsing-disable-download-protection");
            options.setExperimentalOption("prefs", chromePrefs);

            //DRIVER.set(new ChromeDriver(options));
            DRIVER.set(WebDriverManager.chromedriver().capabilities(options).create());
        } else if (browser.equalsIgnoreCase("remote-chrome")) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(Browser.CHROME.browserName());
                caps.setVersion("101");
                DRIVER.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
            } catch (MalformedURLException e) {
                LOG.error(e.getMessage());
            }
        } else if (browser.equalsIgnoreCase("remote-firefox")) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(Browser.FIREFOX.browserName());
                caps.setVersion("99");
                DRIVER.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
            } catch (MalformedURLException e) {
                LOG.error(e.getMessage());
            }
        } else if (browser.equalsIgnoreCase("remote-edge")) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(Browser.EDGE.browserName());
                caps.setVersion("100");
                DRIVER.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
            } catch (MalformedURLException e) {
                LOG.error(e.getMessage());
            }
        } else {
            LOG.error("Browser value is not defined correctly! It should be either chrome, firefox, edge or opera!");
        }
        setupBrowser();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        if (null != DRIVER) {
            getDriver().quit();
            DRIVER.remove();
        }
    }

    private void setupBrowser () {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }
}