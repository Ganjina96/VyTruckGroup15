package com.vytrack.test_features;


import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US13_2_vehicleModelVerification extends TestBase {
    @Test
    public void Drivers_Cant_Access_AllVehicles_Models() throws InterruptedException {
        //        1. After logging into the website verify the title name is "Dashboard
        driver.get(ConfigurationReader.getProperty("env"));
        VyTrack_Utilities.vyTrackLogin(driver, ConfigurationReader.getProperty("TRUCK_DRIVER_1_LOGIN"), ConfigurationReader.getProperty("PASSWORD"));

        //        2. Click on "Fleet" dropdown button
        WebElement fleetDropdownBtn = driver.findElement(By.xpath("(//span[contains(@class, 'title-level-1')])[2]"));
        fleetDropdownBtn.click();
        Thread.sleep(3000);

//        3. Verify "Vehicles Model" option is displayed
        WebElement vehiclesModel = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModel.click();
        Thread.sleep(3000);

//        4. Click and verify "Quick Launchpad" header is still displayed
        Assert.assertEquals(driver.getTitle(), "Dashboard", "Title Verification Failed");
    }
}
