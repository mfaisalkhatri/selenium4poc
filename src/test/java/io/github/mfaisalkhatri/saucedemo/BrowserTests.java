package io.github.mfaisalkhatri.saucedemo;

import org.testng.*;
import org.testng.annotations.*;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class BrowserTests extends Setup {


    private String websiteLink = "http://the-internet.herokuapp.com/";

    @Test
    public void checkTitleAndWebsiteUrlTest () {
        String title = "The Internet";
        driver.get(websiteLink);
        String actualWebsiteLink = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualWebsiteLink,websiteLink);
        Assert.assertEquals(actualTitle,title);

    }

    @Test
    public void browserNavigationTests () {
        driver.get(websiteLink);


    }
}