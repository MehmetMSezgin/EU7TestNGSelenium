package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUps_and_alerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement element = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        //or just //button[1]
        element.click();

        //for popups we have special method in selenium
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept(); //it clicks 'ok' in popup

        //click decline in popup
        WebElement element1 = driver.findElement(By.xpath("//button[2]"));
        element1.click();
        Thread.sleep(2000);
        alert.dismiss();

        //sendKeys to popup
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("Cybertek");


    }






}
