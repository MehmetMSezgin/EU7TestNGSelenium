package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest {
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
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        //this website's HTML text is divided by using iframe and I could not reach second html part without switching
        //1.NAME OR ID --->so I use switchTo.frame() method

        driver.switchTo().frame("mce_0_ifr");//swtich using name or id
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).clear(); //clear the type box, before writing
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("mike smith");

        //from baby html to main html , you need to switch back because selenium can work on only one html text
        driver.switchTo().defaultContent();

        //2.INDEX NUMBER --->by using second way I will switch to baby html again
        driver.switchTo().frame(0); //I have only one baby html , I use 0 as index number

        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("bob smith");

        //second way to get back main html frame
        driver.switchTo().parentFrame();

        //3.WEB ELEMENT --->third way of switching to baby html
        WebElement iFrameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElement);

    }

    @Test
    public void NestedFrames() {
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //Web site general concept
        /* HTML (main)
            1.frame-top
               1.a. left ------> index number
               1.b. middle
               1.c. right
            2.frame-bottom
        * */
        driver.switchTo().frame("frame-top"); //you need to follow hierarchy
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //switching to frame top
        //when I am in frame top . Index number 0=left , 1=middle , 2=right
        driver.switchTo().parentFrame(); //goes back to top frame

        //and now I passed the right
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //I am at right now ,I want to switch the bottom
        //I need to go to default. NOT PARENT
        driver.switchTo().defaultContent();

        //when I am in default --> index number 0 = frame top , 1=frame bottom
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }


}
