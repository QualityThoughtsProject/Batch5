package com.qt.example;

import com.qt.driverfactoty.DriverInit;
import com.qt.utils.ExReporter;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGGroups extends TestNGMethods{

    @Parameters({"UserName","Password"})
    @Test(groups = "parellel")
    public void TestCase1(String userName,String Password){
        DriverInit.initiateDriver("https://www.google.com");
        ExReporter.log(LogStatus.INFO,userName);
        ExReporter.log(LogStatus.WARNING,Password);
        ExReporter.log(LogStatus.FATAL,"Sample Warning");
        ExReporter.log(LogStatus.FAIL,"Sample FAIL");
    }

    @Test(groups = {"sanity","parellel"})
    public void TestCase2(){
        DriverInit.initiateDriver("https://www.facebook.com");
        ExReporter.log(LogStatus.INFO,"Sample Info");
        ExReporter.log(LogStatus.WARNING,"Sample Warning");
        ExReporter.log(LogStatus.FATAL,"Sample Warning");
        ExReporter.log(LogStatus.FAIL,"Sample FAIL");
    }

    @Test(groups = "parellel")
    public void TestCase3(){
        DriverInit.initiateDriver("https://www.instagram.com");
        ExReporter.log(LogStatus.INFO,"Sample Info");
    }

    @Test(groups = "parellel")
    public void TestCase4(){
        DriverInit.initiateDriver("https://www.fipkart.com");
        ExReporter.log(LogStatus.INFO,"Sample Info");
        ExReporter.log(LogStatus.WARNING,"Sample Warning");
    }

    @Test(groups = "parellel")
    public void TestCase5(){
        DriverInit.initiateDriver("https://www.amazon.com");
        ExReporter.log(LogStatus.INFO,"Sample Info");
        ExReporter.log(LogStatus.WARNING,"Sample Warning");
    }
}
