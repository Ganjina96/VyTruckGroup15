package com.vytrack.test_features;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleFuelLog_US_9 extends TestBase {

    @Test
    public void test09_01(){

        //1. user on the https://qa2.vytrack.com/  page
        VyTrack_Utilities.vyTrackLogin(driver, ConfigurationReader.getProperty("TRUCK_DRIVER_1_LOGIN"), ConfigurationReader.getProperty("PASSWORD"));

        //2. navigate and click on the "Fleet" bottom dropdown module
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();

        //3. in the "Fleet" dropdown module navigate and click on the "Vehicles fuel logs"
        driver.findElement(By.partialLinkText("Vehicles Fuel Logs")).click();

        //4. verify that header "Vehicle Fuel Logs" is displayed

        waitPlease.until(ExpectedConditions.titleContains("Vehicle Fuel Logs - Entities - System - Car - Entities - System"));

        WebElement header = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(header.getText(), "Vehicle Fuel Logs");
    }

    @Test
    public void test09_02(){

        //1. user on the https://qa2.vytrack.com/  page
        VyTrack_Utilities.vyTrackLogin(driver, ConfigurationReader.getProperty("SALES_MANAGER_1_LOGIN"), ConfigurationReader.getProperty("PASSWORD"));

        //2. navigate and click on the "Fleet" bottom dropdown module
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();

        //3. in the "Fleet" dropdown module navigate and click on the "Vehicles fuel logs"
        driver.findElement(By.partialLinkText("Vehicles Fuel Logs")).click();

        //4. verify that the message "You do not have permission to perform this action." is displayed
        String expectedMsg = "You do not have permission to perform this action.";
        String actualMsg = driver.findElement(By.xpath("(//div[@class='message'])[2]")).getText();

        Assert.assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void test09_03(){

        //1. user on the https://qa2.vytrack.com/  page
        VyTrack_Utilities.vyTrackLogin(driver, ConfigurationReader.getProperty("STORE_MANAGER_1_LOGIN"), ConfigurationReader.getProperty("PASSWORD"));

        //2. navigate and click on the "Fleet" bottom dropdown module
       WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]"));
       fleet.click();

        //3. in the "Fleet" dropdown module navigate and click on the "Vehicles fuel logs"
        driver.findElement(By.partialLinkText("Vehicles Fuel Logs")).click();

        //4. verify that the message "You do not have permission to perform this action." is displayed
        String expectedMsg = "You do not have permission to perform this action.";
        String actualMsg = driver.findElement(By.xpath("(//div[@class='message'])[2]")).getText();

        Assert.assertEquals(expectedMsg, actualMsg);
    }
}
