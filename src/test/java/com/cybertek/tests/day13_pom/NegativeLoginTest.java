package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("some");
        loginPage.loginBtn.click();

      /*  String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        driver.findElement(By.id("_submit")).click(); */

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }
}
