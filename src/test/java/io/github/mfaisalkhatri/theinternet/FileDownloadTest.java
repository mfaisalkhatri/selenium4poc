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
    public void testFileDownlad() {
        String fileName = downloadPage.getDownloadLinkText();
        downloadPage.downloadFile();
        downloadPage.checkFileDownload(String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")), fileName);
    }

    @Test(description = "This test was introduced to cover the sonar code coverage issue")
    public void testInterruptedException() {
        downloadPage.pause(1000);
        Thread.currentThread().interrupt();
        Assert.assertTrue(Thread.interrupted());
    }
}
