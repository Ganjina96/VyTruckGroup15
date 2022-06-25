package com.vytrack.base;


import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, 10);
    }

    private final List<String> LOGIN_AUTHORIZED_KEYS = new ArrayList<>(Arrays.asList("storemanager79", "storemanager80", "storemanager247", "salesmanager143", "salesmanager144", "salesmanager145"));

    public List<String> getLOGIN_AUTHORIZED_KEYS() {
        return LOGIN_AUTHORIZED_KEYS;
    }

    private final List<String> LOGIN_UNAUTHORIZED_KEYS = new ArrayList<>(Arrays.asList("user42", "user43", "user44"));

    public List<String> getLOGIN_UNAUTHORIZED_KEYS() {
        return LOGIN_UNAUTHORIZED_KEYS;
    }

    public WebDriverWait wait;

    private final String TRUCK_DRIVER_1_LOGIN = "user42";
    private final String TRUCK_DRIVER_2_LOGIN = "user43";
    private final String TRUCK_DRIVER_3_LOGIN = "user44";
    private final String STORE_MANAGER_1_LOGIN = "storemanager79";
    private final String STORE_MANAGER_2_LOGIN = "storemanager80";
    private final String STORE_MANAGER_3_LOGIN = "storemanager247";
    private final String SALES_MANAGER_1_LOGIN = "salesmanager143";
    private final String SALES_MANAGER_2_LOGIN = "salesmanager144";
    private final String SALES_MANAGER_3_LOGIN = "salesmanager145";

    private final String PASSWORD = "UserUser123";


    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }


    public String getTRUCK_DRIVER_1_LOGIN() {
        return TRUCK_DRIVER_1_LOGIN;
    }


    public String getTRUCK_DRIVER_2_LOGIN() {
        return TRUCK_DRIVER_2_LOGIN;
    }

    public String getTRUCK_DRIVER_3_LOGIN() {
        return TRUCK_DRIVER_3_LOGIN;
    }

    public String getSTORE_MANAGER_1_LOGIN() {
        return STORE_MANAGER_1_LOGIN;
    }

    public String getSTORE_MANAGER_2_LOGIN() {
        return STORE_MANAGER_2_LOGIN;
    }

    public String getSTORE_MANAGER_3_LOGIN() {
        return STORE_MANAGER_3_LOGIN;
    }

    public String getSALES_MANAGER_1_LOGIN() {
        return SALES_MANAGER_1_LOGIN;
    }

    public String getSALES_MANAGER_2_LOGIN() {
        return SALES_MANAGER_2_LOGIN;
    }

    public String getSALES_MANAGER_3_LOGIN() {
        return SALES_MANAGER_3_LOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}







