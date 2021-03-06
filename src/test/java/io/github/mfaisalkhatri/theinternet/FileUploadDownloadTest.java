package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadDownloadTest extends Setup {

    private String fileName;
    private DownloadPage downloadPage;
    private FileUploadPage uploadPage;
    private MainPage mainPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        mainPage = new MainPage(getDriver());
        downloadPage = new DownloadPage(getDriver());
        uploadPage = new FileUploadPage(getDriver());
    }

    @Test
    public void testFileDownload () throws InterruptedException {
        mainPage.clickLink("File Download");
        fileName = downloadPage.getDownloadLinkText();
        downloadPage.downloadFile();
        Assert.assertTrue(downloadPage.checkFileDownload(fileName));
        getDriver().navigate().back();
    }

    @Test
    public void testFileUpload () {
        mainPage.clickLink("File Upload");
        uploadPage.uploadFile(fileName);
        Assert.assertEquals(uploadPage.successHeader(), "File Uploaded!");
        Assert.assertEquals(uploadPage.uploadedFileName(), fileName);
    }
}