package io.github.mfaisalkhatri.theinternet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created By Faisal Khatri on 21-01-2022
 */
public class FileUploadPage {

    private static final Logger log = LogManager.getLogger(FileUploadPage.class);
    private final WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement chooseFile() {
        return driver.findElement(By.id("file-upload"));
    }

    public WebElement btnUpload() {
        return driver.findElement(By.id("file-submit"));
    }

    public void uploadFile(String filename) {
        log.info("Starting File Upload");
        File directory = new File(String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")));
        File uploadPath = new File(directory, filename);
        //String uploadPath = directory + "/" + filename;
        log.info("Uploading File from path" + uploadPath);
        chooseFile().sendKeys(uploadPath.toString());
        btnUpload().click();
        log.info("File Uploaded Successfully!!");
    }

    public String successHeader() {
        return driver.findElement(By.tagName("h3")).getText();
    }

    public String uploadedFileName() {
        return driver.findElement(By.id("uploaded-files")).getText();
    }

}