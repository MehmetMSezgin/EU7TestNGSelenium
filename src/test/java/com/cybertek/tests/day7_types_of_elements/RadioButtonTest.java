package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueButton = driver.findElement(By.cssSelector("input[id='blue']"));
        WebElement redButton = driver.findElement(By.cssSelector("#red"));

        System.out.println("blueButton.isSelected() = " + blueButton.isSelected());
        System.out.println("redButton.isSelected() = " + redButton.isSelected());

        //verify blue is selected and red is not selected
        Assert.assertTrue(blueButton.isSelected()); //expectation is true
        Assert.assertFalse(redButton.isSelected()); //expectation is false

        //click on red and check again
        redButton.click();
        Assert.assertFalse(blueButton.isSelected());
        Assert.assertTrue(redButton.isSelected());

        Thread.sleep(2000);
        driver.quit();


    }













}
