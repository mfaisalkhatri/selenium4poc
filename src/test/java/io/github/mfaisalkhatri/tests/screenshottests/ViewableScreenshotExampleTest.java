package io.github.mfaisalkhatri.tests.screenshottests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ViewableScreenshotExampleTest {

    WebDriver driver;

    @BeforeTest
    public void setup () {

        this.driver = new ChromeDriver ();

        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
        this.driver.manage ()
            .window ()
            .maximize ();
    }

    @AfterTest
    public void tearDown () {
        this.driver.quit ();
    }

    @Test
    public void testTakeViewableScreenshot () {

        this.driver.get ("https://ecommerce-playground.lambdatest.io/");

        final WebElement blogMenu = this.driver.findElement (
            By.cssSelector ("div.entry-section div.entry-widget ul > li:nth-child(3) > a > div > span"));
        blogMenu.click ();

        final WebElement firstArticleImage = this.driver.findElement (By.className ("article-thumb"));
        final Actions actions = new Actions (this.driver);
        actions.scrollToElement (firstArticleImage)
            .build ()
            .perform ();

        final WebElement secondArticleImage = this.driver.findElement (
            By.cssSelector (".swiper-wrapper div[aria-label='2 / 10']"));
        actions.scrollToElement (secondArticleImage)
            .build ()
            .perform ();

        final File src = ((TakesScreenshot) this.driver).getScreenshotAs (OutputType.FILE);
        try {
            FileUtils.copyFile (src, new File ("./screenshots/blogpage.png"));
        } catch (final IOException e) {
            throw new RuntimeException (e);
        }
    }
}