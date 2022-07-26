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
package io.github.mfaisalkhatri.tests.theinternet;

import io.github.mfaisalkhatri.pages.theinternet.JSAlertPage;
import io.github.mfaisalkhatri.pages.theinternet.MainPage;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Created By Faisal Khatri on 18-12-2021
 */
public class JSAlertTests extends BaseSuiteSetup {

    private JSAlertPage jsAlertPage;

    @BeforeClass
    private void setupTest () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        MainPage mainPage = new MainPage();
        mainPage.clickLink("JavaScript Alerts");
        jsAlertPage = new JSAlertPage();
    }

    @Test
    public void alertTest () {
        jsAlertPage.jsAlertButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        assertEquals(alertText, "I am a JS Alert");
        jsAlertPage.acceptAlert();
        assertEquals(jsAlertPage.resultText(), "You successfully clicked an alert");
    }

    @Test
    public void confirmAlertTest () {
        jsAlertPage.jsConfirmButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        assertEquals(alertText, "I am a JS Confirm");
        jsAlertPage.acceptAlert();
        assertEquals(jsAlertPage.resultText(), "You clicked: Ok");
    }

    @Test
    public void dismissAlertTest () {
        jsAlertPage.jsConfirmButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        assertEquals(alertText, "I am a JS Confirm");
        jsAlertPage.dismissAlert();
        assertEquals(jsAlertPage.resultText(), "You clicked: Cancel");
    }

    @Test
    public void jsPromptTypeAndAcceptTest () {
        jsAlertPage.jspromptButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        assertEquals(alertText, "I am a JS prompt");
        final String text = "Testing by typing text in JS Alert";
        jsAlertPage.typeTextInAlert(text);
        jsAlertPage.acceptAlert();
        assertEquals(jsAlertPage.resultText(), "You entered: " + text);
    }

    @Test
    public void jsPromptDismissTest () {
        jsAlertPage.jspromptButton().click();
        jsAlertPage.checkForAlert();
        String alertText = jsAlertPage.getAlertText();
        assertEquals(alertText, "I am a JS prompt");
        jsAlertPage.dismissAlert();
        assertEquals(jsAlertPage.resultText(), "You entered: null");
    }
}