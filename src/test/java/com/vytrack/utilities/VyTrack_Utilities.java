package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VyTrack_Utilities {
    public static void vyTrackLogin(WebDriver driver, String username, String password) {

        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();

    }
}
