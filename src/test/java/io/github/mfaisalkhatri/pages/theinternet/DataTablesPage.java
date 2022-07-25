package io.github.mfaisalkhatri.pages.theinternet;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DataTablesPage {

    private final DriverManager driverManager;

    public DataTablesPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement tableOne () {
        return driverManager.getDriver().findElement(By.cssSelector("#table1 > tbody"));
    }

    public List<WebElement> tableRows () {
        return tableOne().findElements(By.tagName("tr"));
    }

    public int totalRows () {
        return tableRows().size();
    }

    public int totalColumns () {
        return driverManager.getDriver().findElements(By.cssSelector("#table1 > thead > tr > th")).size();
    }

    public List<WebElement> columnHeaders () {
        return driverManager.getDriver().findElements(By.cssSelector("#table1 > thead > tr > th"));
    }

    public void printTableRecords () {
        for (int i = 0; i < totalRows(); i++) {
            List<WebElement> tableColumns = tableRows().get(i).findElements(By.tagName("td"));
            for (int j = 0; j < totalColumns(); j++) {
                System.out.println(tableColumns.get(j).getText());
            }
        }
    }

    public List<LinkedHashMap<String, String>> getTableData () {
        List<LinkedHashMap<String, String>> allTableData = new ArrayList<>();
        LinkedHashMap<String, String> eachRowData = null;
        for (int i = 0; i < totalRows(); i++) {
            List<WebElement> tableColumns = tableRows().get(i).findElements(By.tagName("td"));
            eachRowData = new LinkedHashMap<>();
            for (int j = 0; j < totalColumns(); j++) {
                String cellValue = tableColumns.get(j).getText();
                eachRowData.put(columnHeaders().get(j).getText(), cellValue);
            }
            allTableData.add(eachRowData);
        }
        return allTableData;
    }
}