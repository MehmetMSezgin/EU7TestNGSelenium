package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class No_select_dropdown {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        //click to see avaliable options
        dropDownElement.click();

       List<WebElement> dropDownOptions = driver.findElements(By.className("dropdown-item"));
       //be careful find ELEMENTS!!! SSSSS

        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());

        for (WebElement dropDownOption : dropDownOptions) {
            System.out.println("dropDownOption = " + dropDownOption.getText());
        }

        //click yahoo

        dropDownOptions.get(2).click();
        Thread.sleep(3000);



    }


}
