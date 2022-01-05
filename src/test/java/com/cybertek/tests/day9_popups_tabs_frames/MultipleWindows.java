package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("driver.getTitle() before = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();
        //I clicked and new tab has been open but I am still in current tab
        System.out.println("driver.getTitle() after = " + driver.getTitle());

        String currentWindow = driver.getWindowHandle(); //this method collects unique code of the window
        //my current window

        Set<String> windowHandles = driver.getWindowHandles();
        //Set does not keep track , so you cannot reach by index number
        //Also it has not accept duplicate variable

        for (String newWindow : windowHandles) {
            if(!(newWindow.equals(currentWindow))) { //if this window is not equal to my current window
                driver.switchTo().window(newWindow); //use this window as my driver anymore
            }
        }

        System.out.println("driver.getTitle() updatedWindow = " + driver.getTitle());
    }

    @Test //more than two window
    public void Test2() {
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("driver.getTitle() before = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles(); //imagine that you have 3 or more windows


        for (String newWindow : windowHandles) {
            driver.switchTo().window(newWindow);

            if(driver.getTitle().equals("New Window")) { //if you find the window what I want, break the loop
                break;
            }
        }

        System.out.println("driver.getTitle() updatedWindow = " + driver.getTitle());
    }


}
