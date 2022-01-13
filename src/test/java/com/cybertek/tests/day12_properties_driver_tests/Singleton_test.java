package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Singleton_test {

    @Test
    public void test() {
        String s1 = Singleton.getStr();
        String s2 = Singleton.getStr();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void test2() {
        WebDriver driver = Driver.get();
    }

    @Test
    public void test3() { //this driver object is same with test2's driver. It will be automated in same tab
        WebDriver driver = Driver.get();
        driver.get("https:/www.google.com");
    }
}
