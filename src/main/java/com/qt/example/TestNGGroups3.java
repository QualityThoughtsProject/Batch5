package com.qt.example;

import org.testng.annotations.Test;

public class TestNGGroups3 extends TestNGMethods{

    @Test(groups = "sanity")
    public void TestCase1(){
        System.out.println("TestCase 1 From TestNGGroups3");
    }

    @Test(groups = "regression")
    public void TestCase2(){
        System.out.println("TestCase 2 From TestNGGroups3");
    }

    @Test(groups = "regression")
    public void TestCase3(){
        System.out.println("TestCase 3 From TestNGGroups3");
    }

    @Test(groups = "regression")
    public void TestCase4(){
        System.out.println("TestCase 4 From TestNGGroups3");
    }

    @Test(groups = "regression")
    public void TestCase5(){
        System.out.println("TestCase 5 From TestNGGroups3");
    }

}
