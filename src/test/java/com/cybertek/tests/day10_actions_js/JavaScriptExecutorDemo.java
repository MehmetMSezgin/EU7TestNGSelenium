package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void clickWithJS() {
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse =  (JavascriptExecutor) driver ; //casting

        jse.executeScript("arguments[0].click();",dropDownLink); //I use to click the link by using javascript

    }

    @Test
    public void typeWithJS() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver ;

        String text = "hello" ;

        jse.executeScript("arguments[0].setAttribute('value', '" + text +  "')",inputBox);
        //this input box was disable but I force to write there by using javaScript
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        for (int i=0 ; i<10 ; i++) {
            Thread.sleep(300);
            jse.executeScript("window.scrollBy(0,250)");

        }
    }
}
