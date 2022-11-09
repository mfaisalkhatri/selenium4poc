package io.github.mfaisalkhatri.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Faisal Khatri
 * @since 11/2/2022
 **/
public class Retry implements IRetryAnalyzer {

    private static final int maxTry = 3;
    private              int count  = 0;

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
            if (this.count < maxTry) {
                System.out.println ("Retrying test " + iTestResult.getName () + " with status " + getResultStatusName (
                    iTestResult.getStatus ()) + " for the " + (this.count + 1) + " time(s).");
                this.count++;
                return true;
            }
        }
        return false;
    }
}
