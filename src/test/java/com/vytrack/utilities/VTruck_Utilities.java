package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VTruck_Utilities {

   public static List<String> loginAuthorizedKeys=new ArrayList<>(Arrays.asList("storemanager79" , "storemanager80" , "storemanager247", "salesmanager143" , "salesmanager144" , "salesmanager145" ));

    public static List<String> loginUnauthorizedKeys=new ArrayList<>(Arrays.asList("user42","user43","user44"));

    public static String passwordKeys="UserUser123";


    public static void vtruck_login(WebDriver driver, String username, String password){
        WebElement login=driver.findElement(By.xpath("//input[@id='prependedInput']"));
        login.sendKeys(username);
        WebElement passwordInput=driver.findElement(By.cssSelector("input[id='prependedInput2']"));
       passwordInput.sendKeys(password);
        WebElement loginBtn=driver.findElement(By.cssSelector("button[id='_submit']"));
        loginBtn.click();
    }
    public static void vtruck_logout(WebDriver driver) {
        WebElement lacyWhiteBtn = driver.findElement(By.xpath("//a[@href='javascript: void(0);']"));
        lacyWhiteBtn.click();
        WebElement logout = driver.findElement(By.xpath("//a[.='Logout']"));
        logout.click();
    }
}
