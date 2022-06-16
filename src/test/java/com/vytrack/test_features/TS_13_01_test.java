package com.vytrack.test_features;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TS_13_01_test {

    @Test(priority = 1)
    public void test13_01_1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
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
        WebElement fleetDropdownBtn = driver.findElement(By.xpath("(//span[contains(@class, 'title-level-1')])[2]"));
        //Assert.assertTrue(fleetDropdownBtn.isDisplayed());
        fleetDropdownBtn.click();
        Thread.sleep(3000);

//        3. Select and click on "Vehicles Model" option
        /*
         *Remember: If there is no <select> tag, it is called HTML
          dropdown and We handle just as any other web element.
          We locate. We click.
         */
        WebElement vehiclesModel = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModel.click();
        Thread.sleep(3000);


//        4. Verify page's title name contains "All - Vehicles Model"
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "All - Vehicles Model";

        Assert.assertTrue(actualTitle1.contains(expectedTitle1));

//        5. Verify the "All Vehicles Model" header is displayed
        WebElement pageHeader = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));

        Assert.assertTrue(pageHeader.isDisplayed());

        driver.quit();

    }

    @Test
    public void test13_01_2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager79");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);

        WebElement fleetDropdownBtn = driver.findElement(By.xpath("(//span[contains(@class, 'title-level-1')])[2]"));
        fleetDropdownBtn.click();
        Thread.sleep(3000);

        WebElement vehiclesModel = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModel.click();
        Thread.sleep(3000);

//1. After navigated to the “All Vehicles Model” Page verify there are 4 Model Names displayed
        List<WebElement> allModelNames = driver.findElements(By.xpath("//td[@data-column-label='Model Name']"));
        Thread.sleep(3000);
        for (WebElement link : allModelNames) {
            System.out.println("Name of each model "+link.getText());
        }
        Assert.assertTrue(allModelNames.size() >= 4);

//2. Verify “Range Rover” model is displayed
        WebElement rangeRover = driver.findElement(By.xpath("//td[.='RANGE']"));
        Thread.sleep(3000);
        Assert.assertTrue(rangeRover.isDisplayed());

//3. Click and verify the “RANGE ROVER edit Land Rover edit” header is displayed
        rangeRover.click();
        Thread.sleep(3000);
        WebElement pageHeader = driver.findElement(By.cssSelector(".user-name"));
        String actualHeader = pageHeader.getText();
        String expectedHeader = "RANGE Land Rover";
        Assert.assertEquals(actualHeader, expectedHeader);
        driver.navigate().back();

//4. Verify “Tesla” model is displayed
        WebElement tesla = driver.findElement(By.xpath("//td[.='Tesla']"));
        Assert.assertTrue(tesla.isDisplayed());

//5. Click and verify “Tesla TerrificTruck 1” header is displayed
        tesla.click();
        Thread.sleep(3000);
        WebElement pageHeader2 = driver.findElement(By.xpath("//h1[.='Tesla TerrificTruck 1']"));
        actualHeader = pageHeader2.getText();
        expectedHeader = "Tesla TerrificTruck 1";
        Assert.assertEquals(actualHeader, expectedHeader);
        driver.navigate().back();

//6. Verify “Toyota Supra 1996” is displayed and accessible
        WebElement toyota = driver.findElement(By.xpath("//td[.='Toyota Supra 1996']"));
        Assert.assertTrue(toyota.isDisplayed());

//7. Click and verify “Toyota Supra 1996 2 Dr Turbo Hatchback Jim Shorkey” header is displayed
        toyota.click();
        Thread.sleep(3000);
        WebElement pageHeader3 = driver.findElement(By.xpath("//h1[.='Toyota Supra 1996 2 Dr Turbo Hatchback Jim Shorkey']"));
        actualHeader = pageHeader3.getText();
        expectedHeader = "Toyota Supra 1996 2 Dr Turbo Hatchback Jim Shorkey";
        Assert.assertEquals(actualHeader, expectedHeader);


        driver.close();


    }

}
