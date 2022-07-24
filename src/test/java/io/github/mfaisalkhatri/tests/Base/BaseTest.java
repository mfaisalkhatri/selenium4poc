package io.github.mfaisalkhatri.tests.Base;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created By Faisal Khatri on 24-07-2022
 */
public class BaseTest {

    protected DriverManager driverManager;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest (String browserName) {
        driverManager = DriverManager.builder().browser(browserName).build().createDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        driverManager.quitDriver();
    }
}