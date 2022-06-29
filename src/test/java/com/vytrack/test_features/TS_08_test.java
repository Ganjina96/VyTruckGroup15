package com.vytrack.test_features;


import com.vytrack.base.TestBase;

import com.vytrack.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

class TS_08_test extends TestBase {

    @Test(priority = 1)//
    public void UserStory_08() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager79");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);

//        1. After logging into the website verify the title name is "Dashboard"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle, "Title Verification Failed");

//        2. Click on "Fleet" dropdown button
        WebElement fleetDropdownBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        fleetDropdownBtn.click();
        Thread.sleep(2000);

        //..
        //3. in  the "Fleet" dropdown module navigate and click on the "Vehicle Contract ".
        WebElement vehiclesContract = driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehiclesContract.click();
        Thread.sleep(2000);

        // 4.Verify to see all "Vehicle contract " on the grid
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "All - Vehicle Contract";

        Assert.assertTrue(actualTitle1.contains(expectedTitle1));
        Thread.sleep(1000);

        //5. Click the " Create Vahicle Contract" button  " .
        WebElement createVehiclesContract = driver.findElement(By.xpath("//a[contains(@class,'btn main-group')] "));
        createVehiclesContract.click();
        Thread.sleep(2000);

        //6.Verify the users "Create Contract"  button.
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Create Vehicle Contract";

        Assert.assertTrue(actualTitle2.contains(expectedTitle2));
        Thread.sleep(2000);

         //7.Verify the click "Cancel" button...
        WebElement cancelBtn = driver.findElement(By.xpath("//a[contains(@class,'btn back icons')]"));
        cancelBtn.click();
        Thread.sleep(2000);


driver.quit();
    }



}
