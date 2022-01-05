package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class explicit_way_example {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void explicitly() { //if text is HTML's part but not visible in user interface for a while
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement username = driver.findElement(By.id("username"));

        //HOW TO WAIT EXPLICITLY
        //create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.visibilityOf(username));

        //when it is avaliable to use I can send keys anymore
        username.sendKeys("mike");
    }

    @Test
    public void Test2() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();

        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));

        WebDriverWait wait = new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("mike");

    }

}
