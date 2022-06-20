package com.vytrack.test_features;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US03_TruckDr_access_VehicleOdometerPage extends TestBase {
    /**
     *
     * User Story:3.
     *      As a truck driver I should be able to access Vehicle Odometer page
     *
     *  1.Verify that Only truck driver can access to vehicle odometer page
     *      (Note: Not authorized users : Store manager, Sales manager )
     *  2. Verify that truck driver should be able to see all vehicle odometer informations on the grid.
     *  3.Verify that Truck driver should be able to create Vehicle odometer or cancel it.
     *  4.Verify that truck driver should be able to delete or edit Vehicle odometer.
     *  5.Verify that truck driver should be able to reset grid by click on grid settings.
     *
     */

    //Author: Alex Stepan


    @Test
    public void TC1_TruckDr_canAccess_VehicleOdometerPage() throws InterruptedException {
        /**
         * TC 1: Truck Driver can access VehicleOdometerPage
         *
         *  Given  Truck Driver on DashboardPage
         * 	When  Select Vehicle Odometer feature under Fleet module
         * 	Then  navigates to VehicleOdometerPage
         */

        //1. Given  Truck Driver on DashboardPage
            VyTrack_Utilities.vyTrackLogin(driver,getTRUCK_DRIVER_3_LOGIN(),getPASSWORD());
            Thread.sleep(2000);
            DashboardPage_TitleVerify(driver);


        //2. When  Select Vehicle Odometer feature under Fleet module
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();
            driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        //3. Then  navigates to VehicleOdometerPage
        Thread.sleep(2000);
        VehicleOdometerPage_TitleVerify(driver);
    }

    @Test
    public void TC2_StoreMan_canNotAccess_VehicleOdometerPage() throws InterruptedException {
        /**
         * TC 2: StoreManager can NOT access VehicleOdometerPage
         *
         *  Given  StoreManager on DashboardPage
         * 	When  Select Vehicle Odometer feature under Fleet module
         * 	Then  should appear message: You do not have permission to perform this action.
         */

        //1. Given  Store Manager on DashboardPage
            VyTrack_Utilities.vyTrackLogin(driver,getSTORE_MANAGER_2_LOGIN(),getPASSWORD());
            Thread.sleep(2000);
            DashboardPage_TitleVerify(driver);

        //2. When  Select Vehicle Odometer feature under Fleet module

            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();

            driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        //3. Then  should appear message: You do not have permission to perform this action.
            System.out.println("The message: You do not have permission to perform this action. is displayed? =" + driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).isDisplayed(), "The message: You do not have permission,  IS NOT DISPLAYED");
    }

    @Test
    public void TC3_SalesMan_canNotAccess_VehicleOdometerPage() throws InterruptedException {
        /**
         * TC 3: SalesManager can NOT access VehicleOdometerPage
         *
         *  Given  SalesManager on DashboardPage
         * 	When  Select Vehicle Odometer feature under Fleet module
         * 	Then  should appear message: You do not have permission to perform this action.
         */

        //1. Given  Store Manager on DashboardPage
            VyTrack_Utilities.vyTrackLogin(driver,getSALES_MANAGER_2_LOGIN(),getPASSWORD());
            Thread.sleep(2000);
            DashboardPage_TitleVerify(driver);

        //2. When  Select Vehicle Odometer feature under Fleet module
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();

            driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        //3. Then  should appear message: You do not have permission to perform this action.
            System.out.println("The message: You do not have permission to perform this action. is displayed? =" + driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).isDisplayed(), "The message: You do not have permission,  IS NOT DISPLAYED");
    }

    @Test
    public void TC4_TruckDr_canSee_grid_AllVehOdom() throws InterruptedException {
        /**
         * TC 4: Truck Driver can see grid AllVehicleOdometer
         *
         *  Given  Truck Driver on DashboardPage
         * 	When  Select Vehicle Odometer feature under Fleet module
         * 	Then  should see grid AllVehicleOdometer
         */

        //1. Given  Truck Driver on DashboardPage
            VyTrack_Utilities.vyTrackLogin(driver,getTRUCK_DRIVER_3_LOGIN(),getPASSWORD());
            Thread.sleep(2000);
            DashboardPage_TitleVerify(driver);

        //2. When  Select Vehicle Odometer feature under Fleet module
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();
            driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        //3. Then  should see grid AllVehicleOdometer
            System.out.println("The grid All Vehicle Odometer is displayed? = " + driver.findElement(By.xpath("//div[@class='toolbar']")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toolbar']")).isDisplayed(), "The grid All Vehicle Odometer IS NOT DISPLAYED");
    }

    @Test
    public void TC5_TruckDr_canCreate_VehOdom() throws InterruptedException {
        /**
         * TC 5: Truck Driver can create VehicleOdometer
         *
         *  Given  Truck Driver on VehicleOdometerPage
         * 	When  create Vehicle Odometer
         * 	Then should see the created odometer information
         */

        //1. Given  Truck Driver on VehicleOdometerPage
            //login
            VyTrack_Utilities.vyTrackLogin(driver,getTRUCK_DRIVER_3_LOGIN(),getPASSWORD());
            //verify if you are located at Dashboard page, use method
            Thread.sleep(2000);
            DashboardPage_TitleVerify(driver);

            //navigate to Fleet, to Vehicle Odometer
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();
            driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        //2. When  create Vehicle Odometer
            //click on Create Veh Odom Button
            driver.findElement(By.xpath("//a[@title='Create Vehicle Odometer']")).click();

            //verify if you are located at Create Vehicle Odometer page, use method
            Thread.sleep(2000);
            CreateVehicleOdometerPage_TitleVerify(driver);

            // input info: 175000, Tovarish Driver
            driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']")).sendKeys("175000");
            driver.findElement(By.xpath("//input[@name='custom_entity_type[Driver]']")).sendKeys("Tovarish Driver");

            //click on Button Save and Close
            driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        //3. Then should see the created odometer information

            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='control-label'])[1]")).getText(), "175000", "Odometer Value is NOT matching");
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='control-label'])[3]")).getText(), "Tovarish Driver", "Driver info is NOT matching");


    }

//    @Test
//    public void TC6_TruckDr_canCreateAndCancel_VehOdom(){
//        /**
//         * TC 6: Truck Driver can create & cancel VehicleOdometer
//         *
//         *  Given  Truck Driver on VehicleOdometerPage
//         * 	When  create Vehicle Odometer
//         * 	And  cancel created Vehicle Odometer
//         * 	When  create Vehicle Odometer
//         */
//
//    }
//
//    @Test
//    public void TC7_TruckDr_canEdit_VehOdom(){
//        /**
//         * TC 7: Truck Driver can edit VehicleOdometer
//         *
//         *  Given  Truck Driver on VehicleOdometerPage
//         * 	When  selecting any Vehicle Odometer inside grid AllVehicleOdometer
//         * 	And  editing the Vehicle Odometer
//         * 	Then  should see grid AllVehicleOdometer with edited Vehicle Odometer
//         */
//
//    }
//
//    @Test
//    public void TC8_TruckDr_canDelete_VehOdom(){
//        /**
//         * TC 8: Truck Driver can delete VehicleOdometer
//         *
//         *  Given  Truck Driver on VehicleOdometerPage
//         * 	When  selecting any Vehicle Odometer inside AllVehicleOdometer grid
//         * 	And  deleting the Vehicle Odometer
//         * 	Then  should see grid AllVehicleOdometer without deleted Vehicle Odometer
//         */
//
//    }
//
//    @Test
//    public void TC9_TruckDr_canReset_grid_AllVehOdom(){
//        /**
//         * TC 9: Truck Driver can reset grid AllVehicleOdometer
//         *
//         *  Given  Truck Driver on VehicleOdometerPage
//         * 	When  resetting grid AllVehicleOdometer
//         * 	Then  should see resetted grid AllVehicleOdometer
//         */
//
//    }






    /**--------------------METHODS--------------------*/

        // Dashboard page Title verification
    public static void DashboardPage_TitleVerify(WebDriver driver) {
        String act_Title = driver.getTitle();
        String exp_Title = "Dashboard";

        Assert.assertEquals(act_Title, exp_Title, "Dashboard page Title Verification - FAIL");
        System.out.println("------------------------------------------------------");
    }

    // VehicleOdometer page Title verification
    public static void VehicleOdometerPage_TitleVerify(WebDriver driver) {
        String act_Title = driver.getTitle();
        String exp_Title = "Vehicle Odometer - Entities - System - Car - Entities - System";

        Assert.assertEquals(act_Title,exp_Title, "VehicleOdometer page Title Verification - FAIL");
        System.out.println("------------------------------------------------------");
    }

    // CreateVehicleOdometer page Title verification
    public static void CreateVehicleOdometerPage_TitleVerify(WebDriver driver) {
        String act_Title = driver.getTitle();
        String exp_Title = "Create Vehicle Odometer - Entities - System - Car - Entities - System";

        Assert.assertEquals(act_Title,exp_Title, "Create Vehicle Odometer page Title Verification - FAIL");
        System.out.println("------------------------------------------------------");
    }

}
