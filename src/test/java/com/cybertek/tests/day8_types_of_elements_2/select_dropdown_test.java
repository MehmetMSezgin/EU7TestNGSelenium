package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class select_dropdown_test {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //check we have select tag or not
        WebElement element = driver.findElement(By.id("state"));

        // for dropdowns we use selenium's Select method
        Select stateDropdown = new Select(element); //Select method accepts one parameter
        //and I put my element
        
        stateDropdown.getOptions(); //it shows all available dropdown options

        // to see options I will collect in list
        List<WebElement> options = stateDropdown.getOptions();



        System.out.println("options.size() = " + options.size());
        
        //shortcut for each loop
        //write just ite
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
        
    }

    @Test
    public void Test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement element = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(element);

        //verify that first selection is "select a state"
        WebElement firstSelectedOption = stateDropdown.getFirstSelectedOption();

        //Web element cinsinden veriyi aldim simdi string e cevirmem lazim
        String actualText = firstSelectedOption.getText();
        String expectedText = "Select a State" ;

        Assert.assertEquals(actualText,expectedText,"veriyfying");

        //how to select option from dropdown
        //1.select using visible text
        stateDropdown.selectByVisibleText("Virginia");

        //verify
        String expectedOption = "Virginia" ;
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verifying...");

        //2.Select using index
        stateDropdown.selectByIndex(51); //last one I choose actually

        //3.Select by value
        stateDropdown.selectByValue("TX"); //the value in inspect page source


    }




}
