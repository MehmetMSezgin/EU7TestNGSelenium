package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class implicit_way_example {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void implicitly() { ////if text is NOT HTML's part

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        //Implicitily waits only waits until the element located.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //it will wait until find the element. but the max limit is 20 second
        //because I set up

        WebElement element = driver.findElement(By.cssSelector("#finish>h4"));

        System.out.println(element.getText());

    }




}
