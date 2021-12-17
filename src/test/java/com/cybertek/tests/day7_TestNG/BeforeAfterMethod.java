package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {
    @BeforeClass // it runs one time in class, before everything
    public void setUpClass() {
        System.out.println("---before CLASS---");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @Ignore //it ignores and doesn't run
    @Test
    public void test3(){
    }

    @BeforeMethod // it runs before each test
    public void setUp() {
        System.out.println("web driver opening browser");
    }

    @AfterMethod // it runs after each test
    public void tearDown() {
        System.out.println("closing the browser");
    }

    @AfterClass // it runs one time in class, after everything
    public void tearDownClass() {
        System.out.println("---after CLASS---");
    }
}
