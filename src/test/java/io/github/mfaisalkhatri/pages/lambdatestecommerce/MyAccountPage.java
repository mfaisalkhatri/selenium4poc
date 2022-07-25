package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class MyAccountPage {

    private DriverManager driverManager;

    public MyAccountPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String pageHeader () {
        return driverManager.getDriver().findElement(By.tagName("h2")).getText();
    }

}