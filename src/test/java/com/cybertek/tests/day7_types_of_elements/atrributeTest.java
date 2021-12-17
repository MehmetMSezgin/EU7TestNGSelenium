package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class atrributeTest {
    @Test
    public void Test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));

        //checked attribute does not keep any value
        //it will return true or false based on it's selected
        System.out.println(blueRadioBtn.getAttribute("checked"));

        //it gives the all line******** outerHTML
        System.out.println(blueRadioBtn.getAttribute("outerHTML"));
        //<input type="radio" id="blue" name="color" checked="">

        //it gives the text******** innerHTML
        WebElement blue = driver.findElement(By.cssSelector(".form-check-label"));
        System.out.println(blue.getAttribute("innerHTML"));
        //Blue



    }
}
