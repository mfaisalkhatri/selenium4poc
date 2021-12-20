package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created By Faisal Khatri on 20-12-2021
 */
public class DropdownPage {

    private WebDriver driver;

    public DropdownPage (WebDriver driver) {
        this.driver = driver;
    }

    public Select dropDownbox () {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        return select;
    }

    public String getSelectedOption () {
        return dropDownbox().getFirstSelectedOption().getText();
    }
}