package io.github.mfaisalkhatri.devtools;

import io.github.mfaisalkhatri.driversetup.DevToolsSetup;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 21-03-2022
 */
public class LogTest extends DevToolsSetup {

    @Test
    public void checkChromeLogs () {
        chromeDriver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");
    }
}