package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class DataTablesPage {

    private final WebDriver driver;

    public DataTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement tableOne() {
        return driver.findElement(By.cssSelector("#table1 > tbody"));
    }

    public List<WebElement> tableRows() {
        return tableOne().findElements(By.tagName("tr"));
    }

    public int totalRows() {
        return tableRows().size();
    }

    public int totalColumns() {
        return driver.findElements(By.cssSelector("#table1 > thead > tr > th")).size();
    }

    public List<WebElement> columnHeaders() {
        return driver.findElements(By.cssSelector("#table1 > thead > tr > th"));
    }


    public void printTableRecords() {
        for (int i = 0; i < totalRows(); i++) {
            List<WebElement> tableColumns = tableRows().get(i).findElements(By.tagName("td"));
            for (int j = 0; j < totalColumns(); j++) {
                System.out.println(tableColumns.get(j).getText());
            }
        }
    }

    public boolean checkTableRecord(String lastName, String firstName, String email, String due,
                                    String website) {
        for (int i = 0; i < totalRows(); i++) {
            List<WebElement> tableColumns = tableRows().get(i).findElements(By.tagName("td"));
            Map tableMap = new HashMap<String, String>();
//            boolean lastNameFound = false;
            for (int j = 0; j < totalColumns(); j++) {
                tableMap.put(i, tableColumns.get(j).getText());
            }
//                if (tableColumns.get(j).getText().equalsIgnoreCase(lastName)) {
//                    lastNameFound = true;
//                    tableColumns.get(j).getText().equalsIgnoreCase(firstName);
//                    tableColumns.get(j).getText().equalsIgnoreCase(email);
//                    tableColumns.get(j).getText().equalsIgnoreCase(due);
//                    tableColumns.get(j).getText().equalsIgnoreCase(website);
//                }
//            }
//            if (lastNameFound == true) {
//                return true;
//            }
        }
        return false;
    }

    public void getTableData() {
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
        System.out.println(allTableData);
    }
}

