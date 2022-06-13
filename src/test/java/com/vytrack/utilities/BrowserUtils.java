package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

public static void switchWindowAndVerify(WebDriver driver,String expectedURL, String expectedTitle){
    Set<String> allWindowHandles=driver.getWindowHandles();
    for(String eachWindows: allWindowHandles){
        driver.switchTo().window(eachWindows);
        System.out.println("driver.getCurrentUrl()= " + driver.getCurrentUrl());
        if(driver.getCurrentUrl().contains(expectedURL)){
            break;}}
    String actualTitle=driver.getTitle();
    Assert.assertTrue(actualTitle.contains(expectedTitle),"Title verification failed!");
}
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle,"Title verification failed!");}
}
