package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void Test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //verify username inputbox is not displyaed on the screen
        //click on start button
        //verify username displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed());
        WebElement startButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.sendKeys("aaaa");
        Assert.assertTrue(usernameInput.isDisplayed());

    }
}
