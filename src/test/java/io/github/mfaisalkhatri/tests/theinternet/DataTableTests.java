package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.pages.theinternet.DataTablesPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataTableTests extends BaseSuiteSetup {

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driverManager.getDriver().get(websiteLink);
        MainPage mainPage = new MainPage(driverManager);
        mainPage.clickLink("Sortable Data Tables");
    }

    @Test
    public void testDataTable () {
        DataTablesPage dataTablesPage = new DataTablesPage(driverManager);
        dataTablesPage.printTableRecords();
        assertEquals(dataTablesPage.getTableData().get(0).get("Last Name"), "Smith");
        assertEquals(dataTablesPage.getTableData().get(1).get("First Name"), "Frank");

    }

}