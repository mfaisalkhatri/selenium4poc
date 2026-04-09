package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

    public class LoginTest {

        @Test
        public void loginTest() {

            // Launch browser
            WebDriver driver = new ChromeDriver();

            // Open OrangeHRM demo site
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Enter username
            driver.findElement(By.name("username")).sendKeys("Admin");

            // Enter password
            driver.findElement(By.name("password")).sendKeys("admin123");

            // Click login button
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Close browser
            driver.quit();
        }
    }

