package io.github.mfaisalkhatri.tests.screenshottests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ScreenshotWithSeleniumTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        driver = new ChromeDriver(options);
    }

    @Test
    public void testTakeScreenshot() throws IOException {
        BrowsingContext browsingContext = new BrowsingContext(driver, driver.getWindowHandle());

        driver.get("https://ecommerce-playground.lambdatest.io/");

        String screenshot = browsingContext.captureScreenshot();
        byte[] imgByteArray = Base64.getDecoder().decode(screenshot);
        FileOutputStream imgOutFile = new FileOutputStream("./screenshots/screenshot_homepage.png");
        imgOutFile.write(imgByteArray);
        imgOutFile.close();

    }

    @Test
    public void testTakeElementScreenshot() throws IOException {
        BrowsingContext browsingContext = new BrowsingContext(driver,driver.getWindowHandle());
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        String screenshot = browsingContext.captureElementScreenshot(((RemoteWebElement) firstName).getId());

        byte[] imgByteArray = Base64.getDecoder().decode(screenshot);
        FileOutputStream imgOutFile = new FileOutputStream("./screenshots/screenshot_webelement.png");
        imgOutFile.write(imgByteArray);
        imgOutFile.close();

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}