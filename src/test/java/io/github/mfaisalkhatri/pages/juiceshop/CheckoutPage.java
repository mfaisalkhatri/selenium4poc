package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 17-04-2022
 */
public class CheckoutPage {

    private final DriverManager driverManager;
    private final Actions actions;
    private final AddressPage addressPage;
    private final Helper helper;

    public CheckoutPage (DriverManager driverManager) {
        this.driverManager = driverManager;
        actions = new Actions(driverManager.getDriver());
        addressPage = new AddressPage(driverManager);
        helper = new Helper();
    }

    public String appleJuiceText () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-column-product")).getText();
    }

    public String appleJuiceQty () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-quantity > span")).getText();
    }

    public String appleJuicePrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-price")).getText();
    }

    public String bananaJuiceText () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-column-product")).getText();
    }

    public String bananaJuiceQty () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-quantity > span")).getText();
    }

    public String bananaJuicePrice () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-price")).getText();
    }

    public String totalPrice () {
        return driverManager.getDriver().findElement(By.id("price")).getText();
    }

    public WebElement checkoutBtn () {
        return driverManager.getDriver().findElement(By.id("checkoutButton"));
    }

    private WebElement addNewAddressBtn () {
        return driverManager.getDriver().findElement(By.cssSelector("mat-card > div > button"));
    }

    public void checkoutProduct () {
        actions.pause(Duration.ofSeconds(5)).click(checkoutBtn()).build().perform();
    }

    public void addAddressForDelivery (String country, String name, int mobileNumber, String zipCode, String address, String city, String state) {
        addNewAddressBtn().click();
        helper.enterText(addressPage.countryField(), country);
        helper.enterText(addressPage.nameField(), name);
        helper.enterText(addressPage.mobileNumberField(), String.valueOf(mobileNumber));
        helper.enterText(addressPage.zipCodeField(), zipCode);
        helper.enterText(addressPage.addressField(), address);
        helper.enterText(addressPage.cityField(), city);
        helper.enterText(addressPage.stateField(), state);
        addressPage.submitBtn().click();
        addressPage.selectAddressRadioBtn().click();
        addressPage.continueBtn().click();
    }
}