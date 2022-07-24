package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.theinternet.DataTablesPage;
import io.github.mfaisalkhatri.theinternet.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataTableTests extends Setup {
    
    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickLink("Sortable Data Tables");
    }

    @Test
    public void testDataTable () {
        DataTablesPage dataTablesPage = new DataTablesPage(getDriver());
        dataTablesPage.printTableRecords();
        assertEquals(dataTablesPage.getTableData().get(0).get("Last Name"), "Smith");
        assertEquals(dataTablesPage.getTableData().get(1).get("First Name"), "Frank");

    }

}