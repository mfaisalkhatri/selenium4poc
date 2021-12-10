package io.github.mfaisalkhatri.saucedemo;

import io.github.mfaisalkhatri.saucedemo.saucedemo.*;
import org.testng.annotations.*;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class Saucedemotests extends Setup {

    private final String  website = "https://www.saucedemo.com";
    @Test
    public void loginSauceDemoTest () {
        driver.navigate().to(website);
        LoginPage lpage = new LoginPage(driver);
        lpage.websiteLogin("standard_user", "secret_sauce");
    }

    @Test
    public  void logOutSauceDemoTest () {
        MainPage mpage = new MainPage(driver);
        mpage.logoutFromWebSite();
    }
}