package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_assertions_demo {

    @Test
    public void test1() {
        System.out.println("first assertion");
        Assert.assertEquals("title", "tiTle");

        System.out.println("second assertion"); //if first assertion fail, compiler stops execution
        Assert.assertEquals("url", "url");

        //use after method
        //even if you fail , it closes the browser
    }

     @Test
     public void test2() {
         //verify email contains @ sign
        String email = "mikesmith@gmail.com";
        Assert.assertTrue(email.contains("@"),"verify mail");

        }
     @Test
     public void test3() {
        //I want to be sure it is false
         Assert.assertFalse(1<0,"verify that 1 is not smaller than 0");
     }

     @Test
    public void test4() {
        Assert.assertNotEquals("one","two","checking not true");
     }

    }

