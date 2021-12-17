package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("Selenium");

        WebElement search = driver.findElement(By.id("nav-search-submit-button"));
        search.click();

        WebElement results = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(results.getText());

        WebElement resultsSelenium = driver.findElement(By.xpath("(//span[@dir='auto'])[3]"));
        String actualResult = (resultsSelenium.getText());
        actualResult = (resultsSelenium.getText()).substring(1, (actualResult.length()-1));
        System.out.println(resultsSelenium.getText());

        if (actualResult.equalsIgnoreCase("selenium")) {
            System.out.println("test passed");
        }else {
            System.out.println("fail");
        }


        driver.quit();


    }
}
