package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;
//read the properties file configuration.properties
public class ConfigurationReader {
    private static Properties properties;

    static {//why static block Because I want it runs one time before everything
        try {
            //what file read
            String path = "configuration.properties";
            //read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path) ;
            //properties --> class that store properties in key/value format
            properties = new Properties();
            //the values from the file input is loaded/ fed in to the properties object
            properties.load(input);
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) { //this method is pulling information from configuration.properties file
        return  properties.getProperty(keyName); }

}
