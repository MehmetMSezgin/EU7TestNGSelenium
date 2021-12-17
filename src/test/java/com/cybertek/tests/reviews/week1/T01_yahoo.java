package com.cybertek.tests.reviews.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_yahoo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.yahoo.com");

        String title = driver.getTitle();

        if (title.contains("Yahoo")) {
            System.out.println("matched");
        } else {
            System.out.println("not matched");
        }

    }
}
