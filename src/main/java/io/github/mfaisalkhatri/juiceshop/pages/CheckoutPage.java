package io.github.mfaisalkhatri.juiceshop.pages;

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

    public CheckoutPage (WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
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

    public void checkoutProduct () {
        actions.pause(Duration.ofSeconds(2)).click(checkoutBtn()).build().perform();
    }

}