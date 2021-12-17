package com.cybertek.tests.day2_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndURL {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        String title = driver.getTitle(); //shortcut for creating variable . ALT + enter

        System.out.println("title = " + title); // use "soutv" shortcut

        //getting current URL
        String currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        //getPageSource
  //      String pageSource = driver.getPageSource();




    }
}
