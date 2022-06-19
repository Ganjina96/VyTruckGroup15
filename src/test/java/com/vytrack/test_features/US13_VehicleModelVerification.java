package com.vytrack.test_features;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class US13_VehicleModelVerification extends TestBase {

    @Test
    public void Vehicle_Model_Verification() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VyTrack_Utilities.vyTrackLogin(Driver.getDriver(), ConfigurationReader.getProperty("STORE_MANAGER_2_LOGIN"), ConfigurationReader.getProperty("PASSWORD"));

//        1. After logging into the website verify the title name is "Dashboard"
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle, "Title Verification Failed");

//        2. Click on "Fleet" dropdown button
        Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1'][contains(.,'Fleet')]")).click();

//        3. Select and click on "Vehicles Model" option
        /*
         *Remember: If there is no <select> tag, it is called HTML
          dropdown and We handle just as any other web element.
          We locate. We click.
         */
        WebElement vehiclesModel = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModel.click();
        Thread.sleep(3000);


//        4. Verify page's title name contains "All - Vehicles Model"
        String actualTitle1 = Driver.getDriver().getTitle();
        String expectedTitle1 = "All - Vehicles Model";

        Assert.assertTrue(actualTitle1.contains(expectedTitle1));

//        5. Verify the "All Vehicles Model" header is displayed
        WebElement pageHeader = Driver.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']"));

        Assert.assertTrue(pageHeader.isDisplayed());

        Driver.getDriver().quit();

    }

    @Test
    public void Click_And_Access_To_All_Vehicles() throws InterruptedException {

        VyTrack_Utilities.vyTrackLogin(Driver.getDriver(), ConfigurationReader.getProperty("STORE_MANAGER_1_LOGIN"), ConfigurationReader.getProperty("PASSWORD"));

        Thread.sleep(3000);

        WebElement fleetDropdownBtn = Driver.getDriver().findElement(By.xpath("(//span[contains(@class, 'title-level-1')])[2]"));
        fleetDropdownBtn.click();
        Thread.sleep(3000);

        WebElement vehiclesModel = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModel.click();
        Thread.sleep(3000);

//1. After navigated to the “All Vehicles Model” Page verify there are at least 4 Model Names displayed
        List<WebElement> allModelNames = Driver.getDriver().findElements(By.xpath("//td[@data-column-label='Model Name']"));
        Thread.sleep(3000);
        for (WebElement link : allModelNames) {
            System.out.println("Name of each model " + link.getText());
        }
        Assert.assertTrue(allModelNames.size() >= 4);

//2. Click on the 1st option of “All Vehicles Model”
        Driver.getDriver().findElement(By.xpath("(//tbody//tr//td//following-sibling::td[@data-column-label='Model Name'])[1]")).click();
        Thread.sleep(3000);


//3. Verify the page's header contains "Tesla"
        WebElement firstModel = Driver.getDriver().findElement(By.xpath("//h1[@class='user-name']"));
        Thread.sleep(3000);
        Assert.assertTrue(firstModel.getText().contains("Tesla"));
        Driver.getDriver().navigate().back();

//4. Click on the 2nd option of “All Vehicles Model”
        Driver.getDriver().findElement(By.xpath("//tbody//tr[2]//td[@data-column-label='Model Name']")).click();
        Thread.sleep(3000);

//5. Verify the page's header contains "Toyota"
        WebElement secondModel = Driver.getDriver().findElement(By.cssSelector("h1.user-name"));
        Assert.assertTrue(secondModel.getText().contains("Toyota"));
        Driver.getDriver().navigate().back();

        Driver.closeDriver();

    }

}
