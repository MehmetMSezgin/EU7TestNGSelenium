package com.cybertek.tests.day2_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver() ;

        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(2000);

        driver.close(); //close the current tab

        driver.quit(); // it closes the all tabs

        //giving new browser tab
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
}
