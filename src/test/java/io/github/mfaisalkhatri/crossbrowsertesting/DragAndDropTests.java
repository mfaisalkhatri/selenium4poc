package io.github.mfaisalkhatri.crossbrowsertesting;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 30-12-2021
 */
public class DragAndDropTests extends Setup {

    DragAndDropPage dragAndDropPage;

    @BeforeClass
    public void testSetup() {
        String website = "https://crossbrowsertesting.github.io/drag-and-drop.html";
        driver.get(website);
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test
    public void testDragAndDrop () {
        dragAndDropPage.dragAndDropBox();
        Assert.assertEquals(dragAndDropPage.getDroppableBoxText(), "Dropped!");
    }
}