package com.qt.example;

import org.testng.annotations.*;

public class ExampleClass {

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test
    public void Test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @Test
    public  void test3(){
        System.out.println("Test 3");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}