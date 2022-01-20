package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){
        LoginPage login = new LoginPage();
        login.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        login.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        login.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }

    @Test
    public void LoginPageMethodWillBeUsed() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
    }

    @Test
    public void LoginAsStoreManagerAndByUsingLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        Assert.assertEquals(driver.getTitle(),"Dashboard");

    }
}
