package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver; //because I want to reach from another package
    public Actions actions;
    public WebDriverWait wait ;
    public ExtentReports report ; //for building reports

    public ExtentHtmlReporter htmlReporter ; //to create html report file

    public ExtentTest extentLogger; //to define a test, enables adding logs, authors, test steps

    @BeforeTest //I did not use before method and after method because I want to accumulate all test cases in one html file
    public void setUpTest() {
        //initialize the class
        report = new ExtentReports();

        //create a report file
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html"; //normally this report.html part should be dynamic too

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get() ; //new style anymore
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions= new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if(result.getStatus()==ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(3000);
        Driver.closeDriver();
    }

    @AfterTest
    public void teardown(){
        //this is when the report is actually created
        report.flush();

    }

}
