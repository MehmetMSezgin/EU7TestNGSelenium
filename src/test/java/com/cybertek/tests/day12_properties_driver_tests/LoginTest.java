package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase { //!!you can reach from TestBase some utilities

    @Test
    public void OpenBrowserWithConf() {

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.name("_username")).sendKeys(username);
        driver.findElement(By.name("_password")).sendKeys(password + Keys.ENTER);
        //sendKeys(password + Keys.ENTER)  //hit the enter



    }
}
