package io.github.mfaisalkhatri.pages.theinternet;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

import java.io.File;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created By Faisal Khatri on 21-01-2022
 */
public class FileUploadPage {

    private static final Logger LOG = LogManager.getLogger (FileUploadPage.class);
    
    public WebElement btnUpload () {
        return getDriver ().findElement (By.id ("file-submit"));
    }

    public WebElement chooseFile () {
        return getDriver ().findElement (By.id ("file-upload"));
    }

    public String successHeader () {
        return getDriver ().findElement (By.tagName ("h3"))
            .getText ();
    }

    public void uploadFile (final String filename) {
        LOG.info ("Starting File Upload");
        final File directory = new File (String.valueOf (Paths.get (System.getProperty ("user.home"), "Downloads")));
        final File uploadPath = new File (directory, filename);
        LOG.info ("Uploading File from path " + uploadPath);
        chooseFile ().sendKeys (uploadPath.toString ());
        btnUpload ().click ();
        LOG.info ("File Uploaded Successfully!!");
    }

    public String uploadedFileName () {
        return getDriver ().findElement (By.id ("uploaded-files"))
            .getText ();
    }

}