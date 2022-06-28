package com.vytrack.test_features;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TS_10_test extends TestBase {
    @Test
    public void test10_01() throws InterruptedException {
        //1. user on the https://qa2.vytrack.com/  page
        VyTrack_Utilities.vyTrackLogin(driver, getTRUCK_DRIVER_1_LOGIN(), getPASSWORD());
        // 2. navigate and click on the "Fleet" bottom dropdown module
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();

        //3. in the "Fleet" dropdown module navigate and click on the "Vehicles fuel logs"
        driver.findElement(By.partialLinkText("Vehicles Fuel Logs")).click();

        // 4. verify that header "Vehicle Fuel Logs" is displayed
        WebElement header = driver.findElement(By.tagName("h1"));

        header.isDisplayed();

        //5.User able to see all Vehicle Fuel information on the grid
        WebElement gridInfo = driver.findElement(By.id("container"));
        gridInfo.isDisplayed();
    }


    @Test
    public void test10_02(){
        //1. User on the https://qa2.vytrack.com/  page
        VyTrack_Utilities.vyTrackLogin(driver, getTRUCK_DRIVER_1_LOGIN(), getPASSWORD());
       // 2. Navigate and click on the "Fleet" bottom dropdown module
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();
       // 3. In the "Fleet" dropdown module navigate and click on the "Vehicles fuel logs"
        driver.findElement(By.partialLinkText("Vehicles Fuel Logs")).click();
       // 4. Verify that header "Vehicle Fuel Logs" is displayed
        WebElement header = driver.findElement(By.tagName("h1"));

        header.isDisplayed();
       // 5. Verify create Vehicle Fuel logs on the top right-side of the page
        WebElement createVehicleFuelBtn =driver.findElement(By.tagName("a"));
        createVehicleFuelBtn.isDisplayed();
        //6. User able to create Vehicle Fuel or cancel it
        WebElement cancelBtn = driver.findElement(By.partialLinkText("Cancel"));
        WebElement createBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        cancelBtn.isDisplayed();
        createBtn.isDisplayed();
    }
    @Test
    public void test10_03(){
        //1. User on the https://qa2.vytrack.com/  page
        VyTrack_Utilities.vyTrackLogin(driver, getTRUCK_DRIVER_1_LOGIN(), getPASSWORD());
       // 2. Navigate and click on the "Fleet" bottom dropdown module
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();
       // 3. In the "Fleet" dropdown module navigate and click on the "Vehicles fuel logs"
        driver.findElement(By.partialLinkText("Vehicles Fuel Logs")).click();
       // 4. Verify that header "Vehicle Fuel Logs" is displayed
        WebElement header = driver.findElement(By.tagName("h1"));

        header.isDisplayed();
       // 5. User able to see all Vehicle Fuel information on the grid
        WebElement gridInfo = driver.findElement(By.id("container"));
        gridInfo.isDisplayed();
       // 6. User click on the target log

       // 7. User able to Edit , delete Vehicle Fuel Logs or add attachment , add event
    }
    @Test
    public void test10_04(){
       // 1. User on the https://qa2.vytrack.com/  page
        VyTrack_Utilities.vyTrackLogin(driver, getTRUCK_DRIVER_1_LOGIN(), getPASSWORD());
       // 2. Navigate and click on the "Fleet" bottom dropdown module
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();
       // 3. In the "Fleet" dropdown module navigate and click on the "Vehicles fuel logs"
        driver.findElement(By.partialLinkText("Vehicles Fuel Logs")).click();
       // 4. Verify that header "Vehicle Fuel Logs" is displayed
        WebElement header = driver.findElement(By.tagName("h1"));

        header.isDisplayed();
       // 5. User able to see all Vehicle Fuel information on the grid
        WebElement gridInfo = driver.findElement(By.id("container"));
        gridInfo.isDisplayed();
       // 6. User click on reset button on the top right-side on the page
       // 7. User able to reset the grid to default setting
    }

}
