package com.cybertek.tests.day11_webTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webTablesExample {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        // I put here because if my test fails , it will close the browser
    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
       System.out.println("headers = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void numberOfRows() {
        //rows without head row
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(rows.size());
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }


    }

    @Test
    public void getRow() {
        //print the second row info
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(secondRow.getText());

    }

    @Test
    public void getAllRowsDynamically() {
        String xpath1 = "//table[@id='table1']/tbody/tr[";
        String xpath2 = "]";

        for (int i=1 ; i<5 ; i++) {
            String finalXpath = xpath1+ i + xpath2 ;
            System.out.println(driver.findElement(By.xpath(finalXpath)).getText());
        }


    }

    @Test
    public void getAllCellInOneRow() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement element : elements) {
            System.out.println(element.getText());

        }

    }

    @Test
    public void printAllCellsByIndex() {
        
        for (int i = 1; i <=4; i++) {
            System.out.println("Row- " + i);
            for (int j = 1; j <=6 ; j++) {
                List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j +"]"));
                for (WebElement element : elements) {
                    System.out.println(element.getText());
                }
            }
            System.out.println("*************");
        }

    }
}
