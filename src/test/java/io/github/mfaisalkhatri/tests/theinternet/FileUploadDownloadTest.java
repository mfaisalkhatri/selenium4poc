package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.pages.theinternet.DownloadPage;
import io.github.mfaisalkhatri.pages.theinternet.FileUploadPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadDownloadTest extends BaseTest {

    private String fileName;
    private MainPage mainPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        driverManager.getDriver().get(websiteLink);
        mainPage = new MainPage(driverManager);
    }

    @Test
    public void testFileDownload () throws InterruptedException {
        DownloadPage downloadPage = new DownloadPage(driverManager);
        mainPage.clickLink("File Download");
        fileName = downloadPage.getDownloadLinkText();
        downloadPage.downloadFile();
        assertTrue(downloadPage.checkFileDownload(fileName));
        driverManager.getDriver().navigate().back();
    }

    @Test
    public void testFileUpload () {
        mainPage.clickLink("File Upload");
        FileUploadPage uploadPage = new FileUploadPage(driverManager);
        uploadPage.uploadFile(fileName);
        assertEquals(uploadPage.successHeader(), "File Uploaded!");
        assertEquals(uploadPage.uploadedFileName(), fileName);
    }
}