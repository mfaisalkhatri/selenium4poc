package io.github.mfaisalkhatri.pages.lambdatestseleniumplayground;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Faisal Khatri
 * @since 11/16/2022
 **/
public class DropdownPage {

    public void checkIfMultiple () {
        singleSelectDropdownList ().isMultiple ();
    }

    public void getOptions () {
        singleSelectDropdownList ().getOptions ();
    }

    public void selectSingleDayIndex (final int index) {
        singleSelectDropdownList ().selectByIndex (index);
    }

    public void selectSingleDayOption (final String visibleText) {
        singleSelectDropdownList ().selectByVisibleText (visibleText);
    }

    public void selectSingleDayValue (final String value) {
        singleSelectDropdownList ().selectByValue (value);
    }

    private Select singleSelectDropdownList () {
        final WebElement dropdown = getDriver ().findElement (By.id ("select-demo"));
        return new Select (dropdown);
    }
}
