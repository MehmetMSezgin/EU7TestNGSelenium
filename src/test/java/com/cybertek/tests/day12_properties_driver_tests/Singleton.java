package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {
    //singleton class will have private constructor
    //so you cannot create an object

    private Singleton() {}

    private static String str ;
    //once you assign a value, str will keep that
    //because private and static

    public static String getStr() {
        //if str has no value , initialize and return it
        if(str==null) {
            System.out.println("str is null , so assing the new value");
            str= "newValue";
        }else {
            System.out.println("str already has a value");
        }
        return str;
    }
}
