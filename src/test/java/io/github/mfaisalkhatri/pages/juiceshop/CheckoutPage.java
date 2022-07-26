package io.github.mfaisalkhatri.pages.juiceshop;

import io.github.mfaisalkhatri.utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.enterText;


/**
 * Created By Faisal Khatri on 17-04-2022
 */
public class CheckoutPage {
    
    private final Actions actions;
    private final AddressPage addressPage;
    private final Helper helper;

    public CheckoutPage () {
        actions = new Actions(getDriver());
        addressPage = new AddressPage();
        helper = new Helper();
    }

    public String appleJuiceText () {
        return getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-column-product")).getText();
    }

    public String appleJuiceQty () {
        return getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-quantity > span")).getText();
    }

    public String appleJuicePrice () {
        return getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.mat-column-price")).getText();
    }

    public String bananaJuiceText () {
        return getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-column-product")).getText();
    }

    public String bananaJuiceQty () {
        return getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-quantity > span")).getText();
    }

    public String bananaJuicePrice () {
        return getDriver().findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > mat-cell.mat-cell.mat-column-price")).getText();
    }

    public String totalPrice () {
        return getDriver().findElement(By.id("price")).getText();
    }

    public WebElement checkoutBtn () {
        return getDriver().findElement(By.id("checkoutButton"));
    }

    private WebElement addNewAddressBtn () {
        return getDriver().findElement(By.cssSelector("mat-card > div > button"));
    }

    public void checkoutProduct () {
        actions.pause(Duration.ofSeconds(5)).click(checkoutBtn()).build().perform();
    }

    public void addAddressForDelivery (String country, String name, int mobileNumber, String zipCode, String address, String city, String state) {
        addNewAddressBtn().click();
        enterText(addressPage.countryField(), country);
        enterText(addressPage.nameField(), name);
        enterText(addressPage.mobileNumberField(), String.valueOf(mobileNumber));
        enterText(addressPage.zipCodeField(), zipCode);
        enterText(addressPage.addressField(), address);
        enterText(addressPage.cityField(), city);
        enterText(addressPage.stateField(), state);
        addressPage.submitBtn().click();
        addressPage.selectAddressRadioBtn().click();
        addressPage.continueBtn().click();
    }
}