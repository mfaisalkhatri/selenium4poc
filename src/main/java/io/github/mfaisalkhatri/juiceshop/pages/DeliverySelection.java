package io.github.mfaisalkhatri.juiceshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class DeliverySelection {

    private final WebDriver driver;
    private final Actions actions;

    public DeliverySelection (WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public String getDeliveryAddressName () {
        return driver.findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(2)")).getText();
    }

    public String getDeliveryAddress () {
        return driver.findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(3)")).getText();
    }

    public String getDeliveryAddressCountry () {
        return driver.findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(4)")).getText();
    }

    public String getDeliveryAddressPhoneNumber () {
        return driver.findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(5)")).getText();
    }

    public WebElement oneDayDeliveryOption () {
        return driver.findElement(By.cssSelector("input.mat-radio-input"));

    }

    public WebElement continueBtn () {
        return driver.findElement(By.cssSelector(".btn.nextButton"));
    }

    public void selectDeliveryOption () {
        actions.pause(Duration.ofSeconds(2)).click(oneDayDeliveryOption()).build().perform();
        continueBtn().click();
    }
}