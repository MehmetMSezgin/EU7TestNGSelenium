package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        //open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome") ;

        //go to the website
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //go and find in browser which has name attribute equals to email
        WebElement emailInput = driver.findElement(By.name("email")) ;

        String expectedEmail = "mike@smith.com" ;

        //send keyboard action
        emailInput.sendKeys(expectedEmail);
        Thread.sleep(3000);

        //verify that email is displayed in the input box
        // .getText  --- it works %99 and it will return String
        // .getAttribute("value) --- second way
        String actualEmail = emailInput.getAttribute("value"); //alt + enter shortcut for creating local variable

        //compare emails
        if (expectedEmail.equals(actualEmail)) {
            System.out.println("PASSED first Test");
        }else {
            System.out.println("FAILED");
        }

        //second verification
        //click and retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        //after you find the element , dont forget to convert by using .getText
        String actualMessage = actualConfirmationMessage.getText();
        String expectedMessage = "Your e-mail's been sent!" ;

        //compare
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("PASSED second Test");
        }else {
            System.out.println("FAILED");
        }

        driver.quit();


    }
}
