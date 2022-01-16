package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

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
    public void testFileDownlad() throws InterruptedException {
        String fileName = downloadPage.getDownloadLinkText();
        downloadPage.downloadFile();
        Assert.assertTrue(downloadPage.checkFileDownload(String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")), fileName));
    }
}
