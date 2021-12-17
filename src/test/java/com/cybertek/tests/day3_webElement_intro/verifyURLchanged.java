package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome") ;

        //navigate to page
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String firstURL = driver.getCurrentUrl();

        //go and find in browser which has name attribute equals to email
        WebElement emailInput = driver.findElement(By.name("email")) ;

        //send keyboard action
        emailInput.sendKeys("mike@smith.com");
        Thread.sleep(3000);


        //click on retrieve password
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        //get new url
        String secondURL = driver.getCurrentUrl();

        //compare
        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        if (firstURL.equals(secondURL)) {
            System.out.println("FAIL");
        }else  {
            if (secondURL.equals(expectedURL)) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAIL");
            }

        }

        Thread.sleep(3000);
        driver.quit();


    }
}
