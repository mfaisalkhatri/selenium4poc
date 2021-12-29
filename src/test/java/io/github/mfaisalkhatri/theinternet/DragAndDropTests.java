package io.github.mfaisalkhatri.theinternet;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class DragAndDropTests extends Setup {

    DragAndDropPage dragAndDropPage;
    @BeforeClass
    public void setupTests () {
        String website = "http://the-internet.herokuapp.com/";
        driver.get(website);
        MainPage mpage = new MainPage(driver);
        mpage.clickLink("Drag And Drop");
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test
    public void dragAndDropBoxAToB () {
        dragAndDropPage.dragBoxBndDropInBoxA();
        Assert.assertEquals(dragAndDropPage.getHeaderOfBoxB(), "A");
        Assert.assertEquals(dragAndDropPage.getHeaderOfBoxA(), "B");
    }

    @Test
    public void dragAndDropBoxBToA () {
        dragAndDropPage.dragBoxBndDropInBoxA();
        Assert.assertEquals(dragAndDropPage.getHeaderOfBoxA(), "A");
        Assert.assertEquals(dragAndDropPage.getHeaderOfBoxB(), "B");
    }


}