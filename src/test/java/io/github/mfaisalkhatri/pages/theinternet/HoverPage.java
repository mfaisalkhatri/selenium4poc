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

package io.github.mfaisalkhatri.pages.theinternet;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created By Faisal Khatri on 29-12-2021
 */
public class HoverPage {

    private final DriverManager driverManager;


    public HoverPage (DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement imageOne () {
        return driverManager.getDriver().findElement(By.cssSelector("div:nth-child(3) > img"));
    }

    public WebElement imageTwo () {
        return driverManager.getDriver().findElement(By.cssSelector("div:nth-child(4) > img"));
    }

    public WebElement imageThree () {
        return driverManager.getDriver().findElement(By.cssSelector("div:nth-child(5) > img"));
    }

    public void hoverOnImage (WebElement element) {
        Actions action = new Actions(driverManager.getDriver());
        action.moveToElement(element).click().build().perform();
    }

    public String getImageOneName () {
        return driverManager.getDriver().findElement(By.cssSelector("div:nth-child(3) > div > h5")).getText();

    }

    public String getImageTwoName () {
        return driverManager.getDriver().findElement(By.cssSelector("div:nth-child(4) > div > h5")).getText();

    }

    public String getImageThreeName () {
        return driverManager.getDriver().findElement(By.cssSelector("div:nth-child(5) > div > h5")).getText();

    }
}