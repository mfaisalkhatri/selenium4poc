package io.github.mfaisalkhatri.tests.base;

import io.github.mfaisalkhatri.drivers.DevToolsManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class DevToolsBaseSuiteSetup {

    protected DevToolsManager devToolsManager;

    @BeforeClass(alwaysRun = true)
    public void setupTest () {
        devToolsManager = DevToolsManager.builder().build().createDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        devToolsManager.quitDriver();
    }
}