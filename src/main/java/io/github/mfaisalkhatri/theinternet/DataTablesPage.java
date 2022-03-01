package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DataTablesPage {

    private final WebDriver driver;

    public DataTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement tableOne() {
        return driver.findElement(By.cssSelector("#table1 > tbody"));
    }

    public List<WebElement> tableRecord() {
        return tableOne().findElements(By.tagName("tr"));
    }


}
