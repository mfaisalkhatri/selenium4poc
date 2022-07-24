/*      Copyright 2022 Mohammad Faisal Khatri

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package io.github.mfaisalkhatri.tests.automationpractice;

import io.github.mfaisalkhatri.automationpractice.ContactUs;
import io.github.mfaisalkhatri.automationpractice.MainPage;
import io.github.mfaisalkhatri.driversetup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created By Faisal Khatri on 09-12-2021
 */
public class ContactUsTests extends Setup {
    @BeforeClass
    public void setupTests () {
        final String websiteLink = "http://automationpractice.com/index.php";
        getDriver().get(websiteLink);
        MainPage mainPage = new MainPage(getDriver());
        mainPage.contactUsLink().click();
    }

    @Test
    public void relativeLocatorsTest () {
        ContactUs contact = new ContactUs(getDriver());
        final String actualPageHeader = "CUSTOMER SERVICE - CONTACT US";
        String expectedPageHeader = contact.pageHeading();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);

        contact.fillContactForm("Customer service", "abc@gg.com", "123456",
                "This is an automated test message");
        final String expectedSentMessageText = "Your message has been successfully sent to our team.";
        Assert.assertEquals(contact.successSentMessage(), expectedSentMessageText);
    }

}