package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) {
        //open chrome browser by using our method
        WebDriver driver = WebDriverFactory.getDriver("chrome") ;

        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedURL = driver.getCurrentUrl();

        //click on retrive password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")) ;
        retrievePasswordButton.click();

        String actualURL = driver.getCurrentUrl();

        //verify that url did not change
        if (expectedURL.equals(actualURL)) {
            System.out.println("Test passed!!!");
        }else {
            System.out.println("Fail!");
        }


    }
}
