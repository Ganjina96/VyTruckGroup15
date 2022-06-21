package com.vytrack.test_features;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_05_TruckDrv_access_vehCostPage extends TestBase {

    @Test
    public void TC_01_TruckDrvAccessAllVehCostPage() throws InterruptedException {
        /**
         * Given  truck driver on Dashboard page
         * When  select vehicle cost feature under fleet module
         * Then  should see  all Vehicle Costs information
         */

        //1. Given  Truck Driver on DashboardPage
            VyTrack_Utilities.vyTrackLogin(driver,getTRUCK_DRIVER_3_LOGIN(),getPASSWORD());
            Thread.sleep(2000);
            DashboardPage_TitleVerify(driver);

        //2.  When  select vehicle cost feature under fleet module
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();
            driver.findElement(By.partialLinkText("Vehicle Costs")).click();

        //3.  Then  should see  all Vehicle Costs information
            WebElement actualHeader = driver.findElement(By.xpath("//div[@class='toolbar']"));
            System.out.println("actualHeader.isDisplayed() = " + actualHeader.isDisplayed());
            Assert.assertTrue(actualHeader.isDisplayed(), "Actual header is not displayed");



    }

    // Dashboard page Title verification
    public static void DashboardPage_TitleVerify(WebDriver driver) {
        String act_Title = driver.getTitle();
        String exp_Title = "Dashboard";

        Assert.assertEquals(act_Title, exp_Title, "Dashboard page Title Verification - FAIL");
        System.out.println("------------------------------------------------------");
    }



}
