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

    @Override
    public boolean retry (final ITestResult iTestResult) {
        if (!iTestResult.isSuccess ()) {
            if (this.count < maxTry) {
                this.count++;
                iTestResult.setStatus (ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus (ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus (ITestResult.SUCCESS);
        }
        return false;
    }
}
