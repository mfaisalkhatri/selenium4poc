package io.github.mfaisalkhatri.tests.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static io.github.mfaisalkhatri.drivers.DriverManager.createDriver;
import static io.github.mfaisalkhatri.drivers.DriverManager.quitDriver;

/**
 * Created By Faisal Khatri on 24-07-2022
 */
public class BaseSuiteSetup {
    
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest (String browserName) {
        createDriver(browserName);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        quitDriver();
    }
}