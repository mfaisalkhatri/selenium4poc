package io.github.mfaisalkhatri.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

class DownloadPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final FluentWait fluentWait;

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));
    }


    private WebElement downloadLink(String linkText) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
    }

    public void downloadFile(String linkText) {
        downloadLink(linkText).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void checkFileDownload(String downloadPath, String downloadedFileName) {
        File directory = new File(downloadPath);
        String[] fileList = directory.list();

        int flag = 0;
        if (fileList == null) {
            System.out.println("Empty Directory");
        } else {
            for (int i = 0; i < fileList.length; i++) {
                String fileName = fileList[i];
                if (fileName.equalsIgnoreCase(downloadedFileName)) {
                    System.out.println("Downloaded file Found: " + fileName);
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            System.out.println("Error: Downloaded File not found in the path!!");
        }

    }

}
