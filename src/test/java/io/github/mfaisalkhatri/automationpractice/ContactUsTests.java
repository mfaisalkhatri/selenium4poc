package io.github.mfaisalkhatri.automationpractice;

import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class ContactUsTests extends Setup {

    private String websiteLink = "http://automationpractice.com/index.php";

    @Test
    public void relativeLocatorsTest () {
        driver.get(websiteLink);
        MainPage mpage = new MainPage(driver);
        mpage.contactUsLink().click();

        ContactUs contact = new ContactUs(driver);
        String actualPageHeader = "CUSTOMER SERVICE - CONTACT US";
        String expectedPageHeader = contact.pageHeading();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);

        contact.fillContactForm("Customer service", "abc@gg.com", "123456",
                "This is an automated test message");
        String expectedSentMessageText = "Your message has been successfully sent to our team.";
        Assert.assertEquals(contact.successSentMessage(), expectedSentMessageText);
    }

}