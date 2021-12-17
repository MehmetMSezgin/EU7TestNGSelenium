package com.cybertek.tests.day2_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver() ;

        driver.get("https://www.google.com");

        driver.navigate().to("https://www.facebook.com"); // it is another method

        // wait 3 second here then move on
        Thread.sleep(3000); // 3000 milisecond equals to 3 second //this line is java's class not selenium

        driver.navigate().back();

        //refresh the webpage
        driver.navigate().refresh();

    }
}
