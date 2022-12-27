package io.github.mfaisalkhatri.pages.theinternet;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataTablesPage {

    private static final Logger LOG = LogManager.getLogger ("DataTablesPage.class");

    public List<WebElement> columnHeaders () {
        return getDriver ().findElements (By.cssSelector ("#table1 > thead > tr > th"));
    }

    public List<LinkedHashMap<String, String>> getTableData () {
        final List<LinkedHashMap<String, String>> allTableData = new ArrayList<> ();
        LinkedHashMap<String, String> eachRowData = null;
        for (int i = 0; i < totalRows (); i++) {
            final List<WebElement> tableColumns = tableRows ().get (i)
                .findElements (By.tagName ("td"));
            eachRowData = new LinkedHashMap<> ();
            for (int j = 0; j < totalColumns (); j++) {
                final String cellValue = tableColumns.get (j)
                    .getText ();
                eachRowData.put (columnHeaders ().get (j)
                    .getText (), cellValue);
            }
            allTableData.add (eachRowData);
        }
        return allTableData;
    }

    public void printTableRecords () {
        for (int i = 0; i < totalRows (); i++) {
            final List<WebElement> tableColumns = tableRows ().get (i)
                .findElements (By.tagName ("td"));
            for (int j = 0; j < totalColumns (); j++) {
                LOG.info (tableColumns.get (j)
                    .getText ());
            }
        }
    }

    public WebElement tableOne () {
        return getDriver ().findElement (By.cssSelector ("#table1 > tbody"));
    }

    public List<WebElement> tableRows () {
        return tableOne ().findElements (By.tagName ("tr"));
    }

    public int totalColumns () {
        return getDriver ().findElements (By.cssSelector ("#table1 > thead > tr > th"))
            .size ();
    }

    public int totalRows () {
        return tableRows ().size ();
    }
}