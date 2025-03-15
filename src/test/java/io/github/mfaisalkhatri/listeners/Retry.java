package io.github.mfaisalkhatri.listeners;

import java.text.MessageFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.Message;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Faisal Khatri
 * @since 11/2/2022
 **/
public class Retry implements IRetryAnalyzer {

    private static final Logger LOG     = LogManager.getLogger ("Retry.class");
    private static final int    MAX_TRY = 3;
    private              int    count   = 0;

    public String getResultStatusName (final int status) {
        String resultName = null;
        if (status == 1) {
            resultName = "SUCCESS";
        }
        if (status == 2) {
            resultName = "FAILURE";
        }
        if (status == 3) {
            resultName = "SKIP";
        }
        return resultName;
    }

    @Override
    public boolean retry (final ITestResult iTestResult) {
        if (!iTestResult.isSuccess ()) {
            if (this.count >= MAX_TRY) {return false;}
            LOG.info ("Retrying test {} with status {} for the {} time(s)", iTestResult.getName (),
                getResultStatusName (iTestResult.getStatus ()), this.count + 1);
            this.count++;
            return true;
        }
        return false;
    }
}
