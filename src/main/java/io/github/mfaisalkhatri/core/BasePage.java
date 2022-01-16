package io.github.mfaisalkhatri.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {

    private static final Logger log = LogManager.getLogger(BasePage.class);

    public void pause(long timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
    }
}
