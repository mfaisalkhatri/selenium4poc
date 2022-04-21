package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataTableTests extends Setup {

    private DataTablesPage dataTablesPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mpage = new MainPage(getDriver());
        mpage.clickLink("Sortable Data Tables");
        dataTablesPage = new DataTablesPage(getDriver());
    }

    @Test
    public void testDataTable () {
        dataTablesPage.printTableRecords();
        Assert.assertEquals(dataTablesPage.getTableData().get(0).get("Last Name"), "Smith");
        Assert.assertEquals(dataTablesPage.getTableData().get(1).get("First Name"), "Frank");

    }

}