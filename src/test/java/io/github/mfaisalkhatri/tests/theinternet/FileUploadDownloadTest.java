package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.pages.theinternet.DownloadPage;
import io.github.mfaisalkhatri.pages.theinternet.FileUploadPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadDownloadTest extends BaseSuiteSetup {

    private String fileName;
    private MainPage mainPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        mainPage = new MainPage();
    }

    @Test
    public void testFileDownload () throws InterruptedException {
        DownloadPage downloadPage = new DownloadPage();
        mainPage.clickLink("File Download");
        fileName = downloadPage.getDownloadLinkText();
        downloadPage.downloadFile();
        assertTrue(downloadPage.checkFileDownload(fileName));
        getDriver().navigate().back();
    }

    @Test
    public void testFileUpload () {
        mainPage.clickLink("File Upload");
        FileUploadPage uploadPage = new FileUploadPage();
        uploadPage.uploadFile(fileName);
        assertEquals(uploadPage.successHeader(), "File Uploaded!");
        assertEquals(uploadPage.uploadedFileName(), fileName);
    }
}