package io.github.mfaisalkhatri.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public final class Helper {

    private static final Logger LOG = LogManager.getLogger (Helper.class);

    public static void enterText (final WebElement element, final String text) {
        element.click ();
        element.clear ();
        element.sendKeys (text);
    }

    public static void pause (final long timeInMillis) throws InterruptedException {
        Thread.sleep (timeInMillis);
    }

    private Helper () {
        
    }
}