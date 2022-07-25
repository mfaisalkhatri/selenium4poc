package io.github.mfaisalkhatri.pages.theinternet;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created By Faisal Khatri on 21-01-2022
 */
public class FileUploadPage {

    private static final Logger LOG = LogManager.getLogger(FileUploadPage.class);
    private final DriverManager driverManager;

    public FileUploadPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement chooseFile () {
        return driverManager.getDriver().findElement(By.id("file-upload"));
    }

    public WebElement btnUpload () {
        return driverManager.getDriver().findElement(By.id("file-submit"));
    }

    public void uploadFile (String filename) {
        LOG.info("Starting File Upload");
        File directory = new File(String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")));
        File uploadPath = new File(directory, filename);
        LOG.info("Uploading File from path " + uploadPath);
        chooseFile().sendKeys(uploadPath.toString());
        btnUpload().click();
        LOG.info("File Uploaded Successfully!!");
    }

    public String successHeader () {
        return driverManager.getDriver().findElement(By.tagName("h3")).getText();
    }

    public String uploadedFileName () {
        return driverManager.getDriver().findElement(By.id("uploaded-files")).getText();
    }

}