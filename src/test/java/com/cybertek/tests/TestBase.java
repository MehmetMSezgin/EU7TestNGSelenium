package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver; //because I want to reach from another package
    public Actions actions;
    public WebDriverWait wait ;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get() ; //new style anymore
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions= new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        Driver.closeDriver(); //it makes the object(driver in Driver class util) null again

    }
}
