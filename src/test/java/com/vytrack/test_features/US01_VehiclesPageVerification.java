package com.vytrack.test_features;

import com.vytrack.utilities.VyTrack_Utilities;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//Author: Alexey Pak

public class US01_VehiclesPageVerification {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");

    }

    @Test
    public void TC01011() throws InterruptedException {


        //1. After logging into the website verify the title name is "Dashboard"
        VyTrack_Utilities.vyTrackLogin(driver, "user42", "UserUser123");
        Thread.sleep(15000);
        String actualDashboardTitle = driver.getTitle();
        String expectedDashboardTitle = "Dashboard";
        Assert.assertEquals(actualDashboardTitle, expectedDashboardTitle, "Dashboard page titles do not match");

        //2. Click on "Fleet" dropdown button
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')]")).click();

        //3. Select and click on "Vehicles" option
        driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']")).click();
        Thread.sleep(15000);

        //4. Verify the page's title is "Car - Entities - System - Car - Entities - System"
        String actualCarsTitle = driver.getTitle();
        String expectedCarsTitle = "Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualCarsTitle, expectedCarsTitle, "Vehicles page titles do not match");

        //5. Verify the "Cars" header is displayed
        WebElement carsHeader = driver.findElement(By.xpath("//h1[.='Cars']"));
        String actualCarsHeader = carsHeader.getText();
        String expectedCarsHeader = "Cars";
        Assert.assertEquals(actualCarsHeader, expectedCarsHeader, "Headers do not match");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

/*
1. After logging into the website verify the title name is "Dashboard"
2. Click on "Fleet" dropdown button
3. Select and click on "Vehicles" option
4. Verify the page's title is "Car - Entities - System - Car - Entities - System"
5. Verify the "Cars" header is displayed
 */