package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataTableTests extends Setup {

    private DataTablesPage dataTablesPage;

    @BeforeClass
    public void testSetup() {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Sortable Data Tables");
        dataTablesPage = new DataTablesPage(driver);
    }

    @Test
    public void testDataTable() {
        dataTablesPage.printTableRecords();
//        Assert.assertTrue(dataTablesPage.checkTableRecord("Bach", "Frank", "fbach@yahoo.com", "$51.00", "http://www" +
//                ".frank.com"));
        dataTablesPage.getTableData();


    }

}
