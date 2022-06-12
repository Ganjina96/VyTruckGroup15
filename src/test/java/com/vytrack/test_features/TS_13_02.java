package com.vytrack.test_features;

import com.google.common.base.Verify;
import com.vytrack.test_features.base.TestBase;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_13_02 extends TestBase {
    @Test
    public void test13_02_1() throws InterruptedException {
        //        1. After logging into the website verify the title name is "Dashboard
        VyTrack_Utilities.vyTrackLogin(driver, "user42", "UserUser123");

        //        2. Click on "Fleet" dropdown button
        WebElement fleetDropdownBtn = driver.findElement(By.xpath("(//span[contains(@class, 'title-level-1')])[2]"));
        fleetDropdownBtn.click();
        Thread.sleep(3000);

//        3. Verify "Vehicles Model" option is displayed
        WebElement vehiclesModel = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        Assert.assertTrue(vehiclesModel.isDisplayed());
        vehiclesModel.click();
        Thread.sleep(3000);

//        4. Click and verify "Quick Launchpad" header is still displayed
            Assert.assertEquals(driver.getTitle(), "Dashboard", "Title Verification Failed");
    }
}
