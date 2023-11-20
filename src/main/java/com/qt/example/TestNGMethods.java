package com.qt.example;
import com.qt.driverfactoty.DriverInit;
import com.qt.utils.ExReporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestNGMethods {


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(String url){
        ExReporter.initReport("Sample Suite");
    }
    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        ExReporter.initParent("My First test","Sample Suite");
    }

    @Parameters("URL")
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method methodname,String url){
        DriverInit.initiateDriver(url);
        ExReporter.initTest(methodname.getName(),"Sample Suite");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
       ExReporter.endParent("Sample Suite");
        DriverInit.closeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        ExReporter.endReport("Sample Suite");
    }

    @BeforeGroups(value = "parellel",alwaysRun = true)
    public void beforeGroups(){
        System.out.println("Before Groups");
    }

    @AfterGroups(alwaysRun = true)
    public void afterGroups(){
        System.out.println("After Groups");
    }
}
