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

    public boolean checkIfDropdownAllowsMultipleSelection () {
        return singleSelectDropdownList ().isMultiple ();
    }

    public boolean checkIfMultipleDropdownSelectionIsAllowed () {
        return multiSelectDropdownList ().isMultiple ();
    }

    public void deselectAllValues () {
        multiSelectDropdownList ().deselectAll ();
    }

    public void deselectByIndex (int index) {
        multiSelectDropdownList ().deselectByIndex (index);
    }

    public void deselectByValue (String value) {
        multiSelectDropdownList ().deselectByValue (value);
    }

    public void deselectByVisibleText (String text) {
        multiSelectDropdownList ().deselectByVisibleText (text);
    }

    public ArrayList<String> expectedValues (String[] values) {
        ArrayList<String> expectedOptions = new ArrayList<> ();
        expectedOptions.addAll (List.of (values));
        return expectedOptions;
    }

    public List<String> getAllSelectedOptions () {
        final List<WebElement> allOptions = multiSelectDropdownList ().getAllSelectedOptions ();
        final int size = allOptions.size ();
        ArrayList<String> options = new ArrayList<> ();
        for (int i = 0; i < size; i++) {
            options.add (allOptions.get (i)
                .getText ());
        }
        return options;
    }

    public String getFirstSelectedOption () {
        return multiSelectDropdownList ().getFirstSelectedOption ()
            .getText ();
    }

    public String getFirstSelectedValue () {
        btnFirstSelected ().click ();
        return getDriver ().findElement (By.cssSelector ("p.text-size-14:nth-child(1)"))
            .getText ();
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

    public void multiSelectByValues (String[] values) {
        refreshPage ();
        for (int i = 0; i < values.length; i++) {
            multiSelectDropdownList ().selectByValue (values[i]);
        }
    }

    public void refreshPage () {
        getDriver ().navigate ()
            .refresh ();
    }

    public void selectDayByVisibleText (final String visibleText) {
        singleSelectDropdownList ().selectByVisibleText (visibleText);
    }

    public void selectMultipleOptionByIndex (int[] index) {
        refreshPage ();
        for (int i = 0; i < index.length; i++) {
            multiSelectDropdownList ().selectByIndex (index[i]);
        }
    }

    public void selectMultipleOptionByVisibleText (String[] text) {
        refreshPage ();
        for (int i = 0; i < text.length; i++) {
            multiSelectDropdownList ().selectByVisibleText (text[i]);
        }
    }

    public void selectSingleDayIndex (final int index) {
        singleSelectDropdownList ().selectByIndex (index);
    }

    public void selectSingleDayValue (final String value) {
        singleSelectDropdownList ().selectByValue (value);
    }

    private WebElement btnFirstSelected () {
        return getDriver ().findElement (By.id ("printMe"));
    }

    private WebElement btnGetAllSelected () {
        return getDriver ().findElement (By.id ("printAll"));
    }

    private Select multiSelectDropdownList () {
        WebElement multiSelectDropdown = getDriver ().findElement (By.id ("multi-select"));
        return new Select (multiSelectDropdown);
    }

    private Select singleSelectDropdownList () {
        final WebElement dropdown = getDriver ().findElement (By.id ("select-demo"));
        return new Select (dropdown);
    }
}
