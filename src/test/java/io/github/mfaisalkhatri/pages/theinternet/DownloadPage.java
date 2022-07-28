package io.github.mfaisalkhatri.pages.theinternet;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static io.github.mfaisalkhatri.utilities.Helper.pause;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPage {

    private static final Logger        LOG = LogManager.getLogger (DownloadPage.class);
    private final        WebDriverWait wait;

    public DownloadPage () {
        this.wait = new WebDriverWait (getDriver (), Duration.ofSeconds (30));
    }

    public boolean checkFileDownload (final String downloadedFileName) {
        final File directory = new File (String.valueOf (Paths.get (System.getProperty ("user.home"), "Downloads")));
        final String[] fileList = directory.list ();

        int flag = 0;
        if (fileList != null) {
            for (int i = 0; i < fileList.length; i++) {
                final String fileName = fileList[i];
                if (fileName.equalsIgnoreCase (downloadedFileName)) {
                    LOG.info ("Downloaded file Found: " + directory + " " + fileName);
                    flag = 1;
                }
            }
        } else {
            LOG.info ("Downloads directory is Empty!" + directory);
            return false;
        }
        if (flag == 0) {
            LOG.info ("Error: Downloaded File not found in the path!!" + directory);
            return false;
        }
        return true;
    }

    public void downloadFile () throws InterruptedException {
        downloadLink ().click ();
        pause (5000);
    }
    
    public String getDownloadLinkText () {
        LOG.info ("Downloading File :" + downloadLink ().getText ());
        return downloadLink ().getText ();
    }

    private WebElement downloadLink () {
        return this.wait.until (
            ExpectedConditions.presenceOfElementLocated (By.cssSelector ("#content > div > a:nth-child(2)")));
    }
}