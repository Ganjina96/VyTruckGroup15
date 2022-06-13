package com.vytrack.base;


import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
        @BeforeMethod
        public void setUpMethod(){
//        1. Open Chrome browser
//        2. Go to http://practice.cybertekschool.com/dropdown
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            //Providing extra time for our driver before it throws NoSuchElementException
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
        @AfterMethod
        public void tearDownMethod(){

   driver.close();
        }}


