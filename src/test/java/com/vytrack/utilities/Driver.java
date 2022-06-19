package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //By creating a private constr, we are closing access to the obj of this class from the outside class
    private Driver() {
    }

    // We make WebDriver private, because we want to close access from outside of class
    // We make it static, because we will use it inside static method
    private static WebDriver driver;


    //Create a reusable utility method which will return dame driver instance when we call it
    public static WebDriver getDriver() {
        //It will check if driver is null and if it is we will set up browser inside if statement
        //If you already setup driver and using it again for following line of codes, it will return to same driver
        if (driver == null) {
            //I have singelton design pattern in my driver util class, it is checking if driver is null or not, for 1st time we are setting up browser, next time it will not be doing all steps again and again

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // this line terminates the existing driver session. with using this driver will not be even null
            driver = null;
        }
    }
}
