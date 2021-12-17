package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class disabledElements {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.cssSelector("#green"));

        //how to check any element is clickable or not
        greenRadioButton.isEnabled();

        greenRadioButton.click();

        Assert.assertFalse(greenRadioButton.isEnabled());

        Thread.sleep(2000);
    }
    @Test
    public void Test2 () {
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();

            driver.get("http://practice.cybertekschool.com/dynamic_controls");

            WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));
            // or #input-example>input

        inputBox.sendKeys("abc");
        //Test fails
        //ElementNotInteractableException: element not interactable

        }






}
