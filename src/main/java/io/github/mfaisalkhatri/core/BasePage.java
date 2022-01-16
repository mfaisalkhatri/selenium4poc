package io.github.mfaisalkhatri.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {

    private static final Logger log = LogManager.getLogger(BasePage.class);

    public static void pause(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
