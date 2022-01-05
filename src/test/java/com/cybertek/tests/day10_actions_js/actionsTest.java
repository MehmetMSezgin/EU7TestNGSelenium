package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class actionsTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("//img[@alt='User Avatar'][1]"));
        //Actions ---> class that contains all the user interactions
        Actions actions = new Actions(driver);

        actions.moveToElement(img1).perform();
        //perform method implements
        Thread.sleep(1500);

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        WebElement profileTwoViewLink = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/a"));

        Assert.assertTrue(viewLink.isDisplayed(),"verify view link is displayed");
        Assert.assertFalse(profileTwoViewLink.isDisplayed(),"second profile is not visible");
    }

    @Test
    public void forCookies() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        Thread.sleep(1500);
        if(acceptAndClose.size()>0) { //it means if you find any element here just click
            acceptAndClose.get(0).click();
        }
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(1500);

        Actions actions = new Actions(driver);
        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1500);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(source,target).perform();
        Thread.sleep(1000);

    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(1500);

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1500);

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }




}
