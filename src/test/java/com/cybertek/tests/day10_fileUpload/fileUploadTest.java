package com.cybertek.tests.day10_fileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUploadTest {
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
    public void fileUpload() {
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //sending files by using sendKeys method
        //I will handle path in dynamic way
        String projectPath = System.getProperty("user.dir");
        String filePath = "src\\test\\resources\\textfile.txt";

        String fullPath = projectPath+"\\"+ filePath;
        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        //verify
        //getting file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify
        Assert.assertEquals(actualFileName,"textfile.txt");



    }
}
