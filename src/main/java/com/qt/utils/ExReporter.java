package com.qt.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExReporter {

    private static ExtentReports extentDwss;
    public static ExtentTest testParentWss;
    public static String reportPath;
    public static ThreadLocal<ExtentTest> testwss = new ThreadLocal<>();


    public static void initReport(String suiteName) {
        String fileName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        String path = System.getProperty("user.dir") + "//Reports//";
        new File(path + fileName).mkdirs();
        reportPath = path + fileName;
        extentDwss = new ExtentReports(reportPath + "report.htm", true);
    }


    public static void log(LogStatus logStatus, String stepName) {
        testwss.get().log(logStatus, stepName);
        String path = "";
        switch (logStatus) {
            case PASS:
            case FAIL:
                path = CommonMethods.takeScreenshot();
                testwss.get().log(logStatus, stepName + testwss.get().addScreenCapture(path));
                break;
            case INFO:
            case SKIP:
            case WARNING:
                testwss.get().log(logStatus, stepName);
                break;
            case ERROR:
            case UNKNOWN:
            case FATAL:
                testwss.get().log(logStatus, stepName);
                Assert.fail();
                break;
            default:
                break;
        }

    }


    public static void initParent(String testName, String suiteName) {
            testParentWss = extentDwss.startTest(testName);
    }

    public static void initTest(String testName, String desc) {
        testwss.set(getextentwss().startTest(testName, desc));
    }

    public static void assignCatogory(String Catogory) {
        testwss.get().assignCategory(Catogory);
    }

    public static void endParent(String suiteName) {
            extentDwss.endTest(testParentWss);
    }

    public static void endReport(String suiteName) {
            extentDwss.flush();
            //extentDwss.close();
    }

    private static ExtentReports getextentwss() {
                return extentDwss;
    }

}
