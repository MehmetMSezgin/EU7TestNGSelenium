package com.cybertek.tests.day10_fileUpload;

import org.testng.annotations.Test;

public class dynamicFilePathExample {
    @Test
    public void fullPathCreator() {
        String projectPath = System.getProperty("user.dir");
        String filePath = "src\\test\\resources\\textfile.txt";

        String fullPath = projectPath+"\\"+ filePath;
        System.out.println(fullPath);

    }
}
