package io.github.mfaisalkhatri.tests.screenshottests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotWithSeleniumTest {
    private WebDriver driver;
    
    @BeforeTest
    public void setup () {
        final ChromeOptions options = new ChromeOptions ();
        options.setCapability ("webSocketUrl", true);
        this.driver = new ChromeDriver (options);
    }

    @AfterTest
    public void tearDown () {
        this.driver.quit ();
    }

    @Test
    public void testTakeElementScreenshot () throws IOException {
        final BrowsingContext browsingContext = new BrowsingContext (this.driver, this.driver.getWindowHandle ());
        this.driver.get ("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

        final WebElement firstName = this.driver.findElement (By.id ("input-firstname"));
        final String screenshot = browsingContext.captureElementScreenshot (((RemoteWebElement) firstName).getId ());

        final byte[] imgByteArray = Base64.getDecoder ()
            .decode (screenshot);
        final FileOutputStream imgOutFile = new FileOutputStream ("./screenshots/screenshot_webelement.png");
        imgOutFile.write (imgByteArray);
        imgOutFile.close ();

    }

    @Test
    public void testTakeScreenshot () throws IOException {
        final BrowsingContext browsingContext = new BrowsingContext (this.driver, this.driver.getWindowHandle ());

        this.driver.get ("https://ecommerce-playground.lambdatest.io/");

        final String screenshot = browsingContext.captureScreenshot ();
        final byte[] imgByteArray = Base64.getDecoder ()
            .decode (screenshot);
        final FileOutputStream imgOutFile = new FileOutputStream ("./screenshots/screenshot_homepage.png");
        imgOutFile.write (imgByteArray);
        imgOutFile.close ();

    }
}