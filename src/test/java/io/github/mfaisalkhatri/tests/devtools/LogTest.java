package io.github.mfaisalkhatri.tests.devtools;

import io.github.mfaisalkhatri.drivers.DevToolsManager;
import io.github.mfaisalkhatri.tests.base.DevToolsBaseSuiteSetup;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 21-03-2022
 */
public class LogTest extends DevToolsBaseSuiteSetup {

    @Test
    public void checkChromeLogs () {
        DevToolsManager.getDriver ()
            .get ("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");
    }
}