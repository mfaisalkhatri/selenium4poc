package io.github.mfaisalkhatri.tests.base;

import static io.github.mfaisalkhatri.drivers.DriverManager.createDriver;
import static io.github.mfaisalkhatri.drivers.DriverManager.quitDriver;

import io.github.mfaisalkhatri.enums.Browsers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created By Faisal Khatri on 24-07-2022
 */
public class BaseSuiteSetup {

    @Parameters ("browser")
    @BeforeClass (alwaysRun = true)
    public void setupTest (final String browser) {
        createDriver (Browsers.valueOf (browser.toUpperCase ()));
    }

    @AfterClass (alwaysRun = true)
    public void tearDown () {
        quitDriver ();
    }
}