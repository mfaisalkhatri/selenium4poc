package io.github.mfaisalkhatri.tests.screenshottests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FullPageScreenshotTest {

    private WebDriver driver;

    @AfterMethod
    public void tearDown () {
        this.driver.quit ();
    }

    @Test
    public void testTakeFullPageScreenshotFirefox () {

        this.driver = new FirefoxDriver ();

        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
        this.driver.manage ()
            .window ()
            .maximize ();

        this.driver.get ("https://ecommerce-playground.lambdatest.io/");

        final JavascriptExecutor js = (JavascriptExecutor) this.driver;
        final Actions actions = new Actions (this.driver);

        final WebElement topTrendingItemList = this.driver.findElement (By.className ("swiper-wrapper"));
        js.executeScript ("arguments[0].scrollIntoView(true);", topTrendingItemList);
        actions.pause (2000)
            .build ()
            .perform ();

        final WebElement topProducts = this.driver.findElement (By.cssSelector ("#entry_217978 > h3"));
        js.executeScript ("arguments[0].scrollIntoView(true);", topProducts);
        actions.pause (2000)
            .build ()
            .perform ();

        final WebElement bottom = this.driver.findElement (By.className ("article-thumb"));
        js.executeScript ("arguments[0].scrollIntoView(true);", bottom);
        actions.pause (2000)
            .build ()
            .perform ();

        final File src = ((FirefoxDriver) this.driver).getFullPageScreenshotAs (OutputType.FILE);
        try {
            FileUtils.copyFile (src, new File ("./screenshots/fulpagescreenshot.png"));
        } catch (final IOException e) {
            throw new RuntimeException (e);
        }
    }

    @Test
    public void testTakeScreenshotUsingAShot () throws IOException {
        this.driver = new ChromeDriver ();

        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));

        this.driver.get ("https://ecommerce-playground.lambdatest.io/");

        final Object devicePixelRatio = ((JavascriptExecutor) this.driver).executeScript (
            "return window.devicePixelRatio");
        final float windowDPR = Float.parseFloat (devicePixelRatio.toString ());

        final Screenshot screenshot = new AShot ().shootingStrategy (
                ShootingStrategies.viewportPasting (ShootingStrategies.scaling (windowDPR), 1000))
            .takeScreenshot (this.driver);

        ImageIO.write (screenshot.getImage (), "png", new File ("./screenshots/AshotFullPageScreen.png"));

    }

}
