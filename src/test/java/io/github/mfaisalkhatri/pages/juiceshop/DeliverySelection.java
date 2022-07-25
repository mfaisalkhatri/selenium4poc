package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 18-04-2022
 */
public class DeliverySelection {

    private final DriverManager driverManager;
    private final Actions actions;

    public DeliverySelection (DriverManager driverManager) {
        this.driverManager = driverManager;
        actions = new Actions(driverManager.getDriver());
    }

    public String getDeliveryAddressName () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(2)")).getText();
    }

    public String getDeliveryAddress () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(3)")).getText();
    }

    public String getDeliveryAddressCountry () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(4)")).getText();
    }

    public String getDeliveryAddressPhoneNumber () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > div.addressCont > div:nth-child(5)")).getText();
    }

    public WebElement oneDayDeliveryOption () {
        return driverManager.getDriver().findElement(By.cssSelector("input.mat-radio-input"));
    }

    public WebElement continueBtn () {
        return driverManager.getDriver().findElement(By.cssSelector(".btn.nextButton"));
    }

    public void selectDeliveryOption () {
        actions.pause(Duration.ofSeconds(5)).click(oneDayDeliveryOption()).build().perform();
        continueBtn().click();
    }
}