package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownloadTest extends Setup {

    private DownloadPage downloadPage;

    @BeforeClass
    public void testSetup() {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("File Download");
        downloadPage = new DownloadPage(driver);
    }

    @Test
    public void testFileDownlad() {
        final String fileName = "testcafe.png";
        downloadPage.downloadFile(fileName);
        downloadPage.checkFileDownload("C:\\Users\\Faisal Khatri\\Downloads\\", fileName);
    }
}
