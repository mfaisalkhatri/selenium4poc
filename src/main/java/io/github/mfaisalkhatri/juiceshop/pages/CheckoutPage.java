package io.github.mfaisalkhatri.juiceshop.pages;

import io.github.mfaisalkhatri.juiceshop.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Created By Faisal Khatri on 17-04-2022
 */
public class CheckoutPage {

    private final WebDriver driver;
    private final Actions actions;
    private final AddressPage addressPage;
    private final Helper helper;

    public CheckoutPage (WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        addressPage = new AddressPage(driver);
        helper = new Helper(driver);
    }

    public String appleJuiceText () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-column-product")).getText();
    }

    public String appleJuiceQty () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-quantity > span")).getText();
    }

    public String appleJuicePrice () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-price")).getText();
    }

    public String bananaJuiceText () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-column-product")).getText();
    }

    public String bananaJuiceQty () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-quantity > span")).getText();
    }

    public String bananaJuicePrice () {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-price")).getText();
    }

    public String totalPrice () {
        return driver.findElement(By.id("price")).getText();
    }

    public WebElement checkoutBtn () {
        return driver.findElement(By.id("checkoutButton"));
    }

    private WebElement addNewAddressBtn () {
        return driver.findElement(By.cssSelector("mat-card > div > button"));
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