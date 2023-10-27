package com.qt.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ProjectConfig {
    static Properties prop;

    static{
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//ProjectConfig.properties");
            prop=new Properties();
            prop.load(file);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getPropertyValues(String key){
        return prop.getProperty(key);
    }
}
