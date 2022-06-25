package com.vytrack.asignment4.AC_7_test;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test_7_1_1_AC_7_PositiveTest extends TestBase {
    @Test
    public void accessToVehicleContactsAuthorized() {
        //    7.1.1. 1.After logged in to website with valid store manager/ sales manager credentials
        driver.get("https://qa2.vytrack.com/");
        for (int i = 0; i < getLOGIN_AUTHORIZED_KEYS().size(); i++) {
           VyTrack_Utilities.vyTrackLogin(driver, getLOGIN_AUTHORIZED_KEYS().get(i),getPASSWORD());

            //    2.Verify the title name is "Dashboard"
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.titleContains("Dashboard"));
            BrowserUtils.verifyTitle(driver, "Dashboard");

            //    3. Click on the "Fleet" dropdown list
            WebElement fleetDropdownList = driver.findElement(By.xpath("//i[@class='fa-asterisk menu-icon']/parent::span[@class='title title-level-1']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa-asterisk menu-icon']/parent::span[@class='title title-level-1']")));
            fleetDropdownList.click();

            //    4. Click on the "Vehicle Contacts" option
            WebElement vehicleContactsOption = driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Vehicle Contracts']")));
            vehicleContactsOption.click();

            //  5. Verify title name is "All - Vehicle Contract - Entities - System - Car - Entities - System"
            wait.until(ExpectedConditions.titleContains("All - Vehicle Contract - Entities - System - Car - Entities - System"));
            BrowserUtils.verifyTitle(driver, "All - Vehicle Contract - Entities - System - Car - Entities - System");

            //6. Log out from the application to repeat the same steps for each authorized user
            VyTrack_Utilities.vyTrack_logout(driver);
        }
    }
}
