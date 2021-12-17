package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextandPartialLinkText {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome") ;

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        // you need to copy all link of the text
        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();

        //partialLinkText
        //I just copied one unique part of the link
        WebElement link2 = driver.findElement(By.partialLinkText("Example 2"));
        link2.click();
    }
}
