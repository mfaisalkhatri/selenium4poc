package io.github.mfaisalkhatri.pages.theinternet;

import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.utilities.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

public class DownloadPage {

    private static final Logger LOG = LogManager.getLogger(DownloadPage.class);
    private final WebDriverWait wait;
    private Helper helper;

    public DownloadPage (DriverManager driverManager) {
        wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(30));
        helper = new Helper();
    }

    private WebElement downloadLink () {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content > div > a:nth-child(2)")));
    }

    public String getDownloadLinkText () {
        LOG.info("Downloading File :" + downloadLink().getText());
        return downloadLink().getText();
    }

    public void downloadFile () throws InterruptedException {
        downloadLink().click();
        helper.pause(5000);
    }

    public boolean checkFileDownload (String downloadedFileName) {
        File directory = new File(String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")));
        String[] fileList = directory.list();

        int flag = 0;
        if (fileList != null) {
            for (int i = 0; i < fileList.length; i++) {
                String fileName = fileList[i];
                if (fileName.equalsIgnoreCase(downloadedFileName)) {
                    LOG.info("Downloaded file Found: " + directory + " " + fileName);
                    flag = 1;
                }
            }
        } else {
            LOG.info("Downloads directory is Empty!" + directory);
            return false;
        }
        if (flag == 0) {
            LOG.info("Error: Downloaded File not found in the path!!" + directory);
            return false;
        }
        return true;
    }
}