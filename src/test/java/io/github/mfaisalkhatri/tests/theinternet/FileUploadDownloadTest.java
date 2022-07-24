package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import io.github.mfaisalkhatri.theinternet.DownloadPage;
import io.github.mfaisalkhatri.theinternet.FileUploadPage;
import io.github.mfaisalkhatri.theinternet.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadDownloadTest extends Setup {

    private String fileName;
    private MainPage mainPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        mainPage = new MainPage(getDriver());
    }

    @Test
    public void testFileDownload () throws InterruptedException {
        DownloadPage downloadPage = new DownloadPage(getDriver());
        mainPage.clickLink("File Download");
        fileName = downloadPage.getDownloadLinkText();
        downloadPage.downloadFile();
        assertTrue(downloadPage.checkFileDownload(fileName));
        getDriver().navigate().back();
    }

    @Test
    public void testFileUpload () {
        mainPage.clickLink("File Upload");
        FileUploadPage uploadPage = new FileUploadPage(getDriver());
        uploadPage.uploadFile(fileName);
        assertEquals(uploadPage.successHeader(), "File Uploaded!");
        assertEquals(uploadPage.uploadedFileName(), fileName);
    }
}