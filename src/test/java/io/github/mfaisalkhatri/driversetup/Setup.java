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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
    public void setupClass() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.operadriver().setup();
    }

    @Parameters("browser")
    @BeforeClass
    public void setupTest(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            // FirefoxOptions options = new FirefoxOptions();
            // options.addArguments("--websocket-port", "4444");
            //driver = new FirefoxDriver(options);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1050,600");
            // options.addArguments("--headless");

            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
        else if (browser.equalsIgnoreCase("opera")) driver = new OperaDriver();
        else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1050,600");
            // options.addArguments("--headless");

            driver = new ChromeDriver(options);

        } else
            // FIXME: Throw an Error here
            System.out.println("Browser value is not defined correctly! It should be either chrome, firefox, edge or opera!");
        setupBrowser();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    private void setupBrowser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

    }
}