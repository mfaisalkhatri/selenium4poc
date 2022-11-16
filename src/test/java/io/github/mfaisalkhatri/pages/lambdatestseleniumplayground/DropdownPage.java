package io.github.mfaisalkhatri.pages.lambdatestseleniumplayground;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Faisal Khatri
 * @since 11/16/2022
 **/
public class DropdownPage {

    public boolean checkIfMultiple () {
        return singleSelectDropdownList ().isMultiple ();
    }

    public ArrayList<String> expectedDropdownOptions () {
        ArrayList<String> expectedOptions = new ArrayList<> ();
        expectedOptions.add ("Please select");
        expectedOptions.add ("Sunday");
        expectedOptions.add ("Monday");
        expectedOptions.add ("Tuesday");
        expectedOptions.add ("Wednesday");
        expectedOptions.add ("Thursday");
        expectedOptions.add ("Friday");
        expectedOptions.add ("Saturday");
        return expectedOptions;
    }

    public ArrayList<String> getOptions () {
        final List<WebElement> allOptions = singleSelectDropdownList ().getOptions ();
        final int size = allOptions.size ();
        ArrayList<String> options = new ArrayList<> ();
        for (int i = 0; i < size; i++) {
            options.add (allOptions.get (i)
                .getText ());
        }
        return options;
    }

    public String getSelectedDropDownText () {
        return getDriver ().findElement (By.cssSelector ("p.selected-value"))
            .getText ();
    }

    public void selectDayByVisibleText (final String visibleText) {
        singleSelectDropdownList ().selectByVisibleText (visibleText);
    }

    public void selectSingleDayIndex (final int index) {
        singleSelectDropdownList ().selectByIndex (index);
    }

    public void selectSingleDayValue (final String value) {
        singleSelectDropdownList ().selectByValue (value);
    }

    private Select singleSelectDropdownList () {
        final WebElement dropdown = getDriver ().findElement (By.id ("select-demo"));
        return new Select (dropdown);
    }
}
