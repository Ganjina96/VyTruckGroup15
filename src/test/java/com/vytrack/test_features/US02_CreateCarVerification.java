package com.vytrack.test_features;

import com.vytrack.base.TestBase;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//Author: Alexey Pak
public class US02_CreateCarVerification extends TestBase {
    @Test
    public void tc02011() throws InterruptedException {

        //1. Login into the website, the title is "Dashboard"
        VyTrack_Utilities.vyTrackLogin(driver,ConfigurationReader.getProperty("STORE_MANAGER_1_LOGIN"),
                ConfigurationReader.getProperty("PASSWORD"));
        Thread.sleep(25000);

        //2. Hover over the Fleet menu button
        //3. Click on the Vehicles option
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]")).click();
        //  Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']")).click();

        Thread.sleep(5000);

        //4. Verify the page's title is "All - Car - Entities - System - Car - Entities - System"

        String actualTitle = driver.getTitle();
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";

        Assert.assertEquals(actualTitle,expectedTitle,"Titles don't match!");

        //5. Click on "Create Car" button
        driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']")).click();

        //6. Enter data
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[starts-with(@id,'custom_entity_type_LicensePlate')]")).sendKeys("TestLicensePlateAP01");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='senior']")).click();
        driver.findElement(By.xpath("//input[starts-with(@id,'custom_entity_type_Driver-uid')]")).sendKeys("TestDriverAP01");
        driver.findElement(By.xpath("//input[starts-with(@id,'custom_entity_type_Location-uid')]")).sendKeys("TestLocationAP01");
        driver.findElement(By.xpath("//input[starts-with(@id,'custom_entity_type_ChassisNumber-uid')]")).sendKeys("01");
        driver.findElement(By.xpath("(//button[@class='btn btn-medium add-btn'])[1]")).click();
        driver.findElement(By.xpath("//td[.='2107']/preceding-sibling::td/input")).click();
        driver.findElement(By.xpath("//button[@data-action-name='select']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("//td[.='Lada']/preceding-sibling::td/input")).click();
        driver.findElement(By.xpath("//button[.='Select']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Save and Close')]")).click();

        Thread.sleep(5000);
        //8. Verify the message "Entity Saved" is displayed
        WebElement entitySaved = driver.findElement(By.xpath("//div[.='Entity saved']"));
        String actualMessage = entitySaved.getText();
        String expectedMessage = "Entity saved";
        Assert.assertEquals(actualMessage,expectedMessage,"Messages do not match!");

        //9. Verify the vehicle is created in the General Information section
        WebElement licensePlateValue = driver.findElement(By.xpath("//div[contains(text(),'TestLicensePlateAP01')]"));
        String actualLicensePlate = licensePlateValue.getText();
        String expectedLicensePlate = "TestLicensePlateAP01";
        Assert.assertEquals(actualLicensePlate,expectedLicensePlate);

    }
}
/*
1. Login into the website, the title is "Dashboard"
2. Hover over the Fleet menu button
3. Click on the Vehicles option
4. Verify the page's title is "All - Car - Entities - System - Car - Entities - System"
5. Click on "Create Car" button
6. Enter data
7. Click on Save and Close button
8. Verify the message "Entity Saved" is displayed
9. Verify the vehicle is created in the General Information section
 */