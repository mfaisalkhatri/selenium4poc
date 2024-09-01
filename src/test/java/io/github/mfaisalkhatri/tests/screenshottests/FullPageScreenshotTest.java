package io.github.mfaisalkhatri.tests.screenshottests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FullPageScreenshotTest {

    WebDriver driver;

    @Test
    public void testTakeFullPageScreenshotFirefox() {

        driver = new FirefoxDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://ecommerce-playground.lambdatest.io/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        WebElement topTrendingItemList = driver.findElement(By.className("swiper-wrapper"));
        js.executeScript("arguments[0].scrollIntoView(true);", topTrendingItemList);
        actions.pause(2000).build().perform();

        WebElement topProducts = driver.findElement(By.cssSelector("#entry_217978 > h3"));
        js.executeScript("arguments[0].scrollIntoView(true);",topProducts);
        actions.pause(2000).build().perform();

        WebElement bottom = driver.findElement(By.className("article-thumb"));
        js.executeScript("arguments[0].scrollIntoView(true);", bottom);
        actions.pause(2000).build().perform();

        File src = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("./screenshots/fulpagescreenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTakeScreenshotUsingAShot() throws IOException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://ecommerce-playground.lambdatest.io/");

        Object devicePixelRatio = ((JavascriptExecutor)driver).executeScript("return window.devicePixelRatio");
        float windowDPR = Float.parseFloat(devicePixelRatio.toString());

        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(windowDPR),1000))
                .takeScreenshot(driver);

        ImageIO.write(screenshot.getImage(), "png", new File("./screenshots/AshotFullPageScreen.png"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
