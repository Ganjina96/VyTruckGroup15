package com.vytrack.test_features;


import com.vytrack.base.TestBase;

import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_04_01_test extends TestBase {

    @Ignore
    @Test
    public void deleteCost() throws InterruptedException {

//        1. Login into the website and click on "Fleet" dropdown button
        //TODO
        //VyTrack_Utilities.vyTrackLogin(driver, getSALES_MANAGER_1_LOGIN(), getPASSWORD());
        Thread.sleep(25000);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();


//        2. Select and click on "Vehicles costs" option
        driver.findElement(By.partialLinkText("Vehicle Costs")).click();
        Thread.sleep(5000);

//        3. Locate and click on "Summer Tires" row item
        driver.findElement(By.xpath("//td[contains(text(), 'Road Assistance')]")).click();
        Thread.sleep(5000);

//        4. Verify General Information header is displayed
        WebElement generalInfo = driver.findElement(By.xpath("//span[.='General Information']"));
        Assert.assertEquals(generalInfo.getText(), "General Information");

//        5. Locate and click on Delete button
        driver.findElement(By.xpath("//a[@title ='Delete Vehicle Costs']")).click();
        Thread.sleep(5000);

//        6. Verify the pop up message to be "Are you sure you want to delete this Vehicle Costs?"
        WebElement popUpMessage = driver.findElement(By.xpath("//div[.='Are you sure you want to delete this Vehicle Costs?']"));
        Assert.assertEquals(popUpMessage.getText(), "Are you sure you want to delete this Vehicle Costs?");

//        7. Locate and click on Yes, Delete button
        driver.findElement(By.xpath("//a[.='Yes, Delete']")).click();
        Thread.sleep(5000);

//        8. Verify the Vehicle Cost Deleted message
        WebElement message = driver.findElement(By.xpath("//div[@class ='flash-messages-holder']"));
        Assert.assertTrue(message.getText().contains("deleted"), "Vehicle Costs deleted not found");

    }
}
