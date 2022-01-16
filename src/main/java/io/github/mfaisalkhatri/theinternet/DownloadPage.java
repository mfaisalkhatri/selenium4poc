package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class DownloadPage extends BasePage {

    private static final Logger log = LogManager.getLogger(DownloadPage.class);
    private final WebDriverWait wait;

    public DownloadPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private WebElement downloadLink() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content > div > a:nth-child(4)")));
    }

    public String getDownloadLinkText() {
        return downloadLink().getText();
    }

    public void downloadFile() throws InterruptedException {
        downloadLink().click();
        pause(5000);
    }

    public boolean checkFileDownload(String downloadPath, String downloadedFileName) {
        File directory = new File(downloadPath);
        String[] fileList = directory.list();

        int flag = 0;
        if (fileList != null) {
            for (int i = 0; i < fileList.length; i++) {
                String fileName = fileList[i];
                if (fileName.equalsIgnoreCase(downloadedFileName)) {
                    log.info("Downloaded file Found: " + fileName);
                    flag = 1;
                    return true;
                }
            }
        } else {
            log.info("Downloads directory is Empty!");
        }
        if (flag == 0) {
            log.info("Error: Downloaded File not found in the path!!");
        }
        return false;
    }
}
