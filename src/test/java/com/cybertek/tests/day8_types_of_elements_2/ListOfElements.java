package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver ;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //if I put there quit() and test fails quit wont be run

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        //alt + enter ---> shortcut
        //6 elements I am able to keep here in List
        //arrayList actually


        System.out.println("buttons.size() = " + buttons.size()); //soutv
        //how many element I have , it shows

        Assert.assertEquals(buttons.size(), 6, "verify buttons size");

        //java index starts from 0 but html index from 1
        // write iter and just click enter
        for (WebElement button : buttons) {
            System.out.println(button.getText());

        }

        for (WebElement button : buttons) {
            System.out.println(button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(), "verified");
            //by using assertion I need to verify
        }

        //click second button
        buttons.get(1); //it is reaching the second item
        buttons.get(1).click();
    }

        @Test
        public void Test2() {
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

            //even if you use wrong locator list has been created
            //but size of list would be 0
            List<WebElement> elements = driver.findElements(By.tagName("abcd"));
            System.out.println(elements.size());
            //so actually it shows test is passed
            //so you should use assertion to verify

        }



}
