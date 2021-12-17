package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
    //we have to enter this line every time we want to open chrome
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); //creating object //polymorphosim
// driver represents my chrome tab
        driver.get("https://cydeo.com/");
// .get(url) method used for navigation to page
    }
}
