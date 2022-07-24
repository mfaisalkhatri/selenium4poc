package io.github.mfaisalkhatri.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Helper {

    private static final Logger LOG = LogManager.getLogger(Helper.class);
    
    public void enterText (WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void pause (long timeInMillis) throws InterruptedException {
        LOG.info("Pausing the driver for " + timeInMillis + " ms");
        Thread.sleep(timeInMillis);
    }
}