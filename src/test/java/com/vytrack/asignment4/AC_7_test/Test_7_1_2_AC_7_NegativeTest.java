package com.vytrack.asignment4.AC_7_test;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_7_1_2_AC_7_NegativeTest extends TestBase {
    @Test
    public void accessToVehicleContactsAuthorized() {
        // 7.1.2. 1.After logged in to website with valid truck driver credentials (unauthorized user)
        driver.get("https://qa2.vytrack.com/");
        for (int i = 0; i < getLOGIN_UNAUTHORIZED_KEYS().size(); i++) {
            VyTrack_Utilities.vyTrackLogin(driver, getLOGIN_UNAUTHORIZED_KEYS().get(i), getPASSWORD());

            // 2.Verify the title name is  "Dashboard"
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.titleContains("Dashboard"));
            BrowserUtils.verifyTitle(driver, "Dashboard");

            //  3. Click on the "Fleet" dropdown list
            WebElement fleetDropdownBtn = driver.findElement(By.xpath("//i[@class='fa-asterisk menu-icon']/parent::span[@class='title title-level-1']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa-asterisk menu-icon']/parent::span[@class='title title-level-1']")));
            fleetDropdownBtn.click();

            //    4. Click on the "Vehicle Contacts" option
            WebElement vehicleContactsOption = driver.findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleContract']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/entity/Extend_Entity_VehicleContract']")));
            vehicleContactsOption.click();

            //  5. Verify popup message is "You do not have permission to perform this action."
            WebElement popUpMsg = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
            String actualMsg = popUpMsg.getText();
            String expectedMsg = "You do not have permission to perform this action.";
            Assert.assertEquals(actualMsg, expectedMsg, "Alert verification is failed!");

// 6. Verify the title is "Dashboard"
            BrowserUtils.verifyTitle(driver, "Dashboard");

            //7.Log out from the application to repeat the same steps for each unauthorised user using for loop
            VyTrack_Utilities.vyTrack_logout(driver);
        }
    }
}