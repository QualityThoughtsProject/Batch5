package com.qt.example;

import com.qt.driverfactoty.DriverInit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgGroups2 {
    @Test(groups = {"sanity","example"},retryAnalyzer = MyRetry.class)
    public void TestCase1(){
        //DriverInit.initiateDriver();
        //Assert.fail();
        //System.out.println("TestCase 1 From TestNGGroups2");
    }

    @Test(groups = {"regression","example"},dependsOnMethods = "TestCase1")
    public void TestCase2(){
        System.out.println("TestCase 2 From TestNGGroups2");
    }

    @Test(groups = "regression")
    public void TestCase3(){
        System.out.println("TestCase 3 From TestNGGroups2");
    }

    @Test(groups = "regression")
    public void TestCase4(){
        System.out.println("TestCase 4 From TestNGGroups2");
    }

    @Test
    public void TestCase5(){
        System.out.println("TestCase 5 From TestNGGroups2");
    }
}
