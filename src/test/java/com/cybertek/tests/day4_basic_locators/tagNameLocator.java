package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome") ;

        //full screen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.tagName("input"));
        fullName.sendKeys("mike smith");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mike@smith.com");

        driver.findElement(By.name("wooden_spoon")).click();
    }
}
