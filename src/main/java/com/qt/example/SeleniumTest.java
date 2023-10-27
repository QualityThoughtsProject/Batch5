package com.qt.example;

import com.qt.driverfactoty.DriverInit;
import com.qt.pom.AccountOverView;
import com.qt.pom.OpenAccountPage;
import com.qt.pom.RegisterPage;
import com.qt.utils.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qt.utils.CommonMethods;


public class SeleniumTest {

    @BeforeMethod
    public void beforeMethod() {
        DriverInit.initiateDriver();
    }

    @Test
    public void RegisterAccount() {
        TestData.readTestData("TC001");
        RegisterPage registerPage = new RegisterPage(DriverInit.getCurrentDriver());
        OpenAccountPage accountPage=new OpenAccountPage(DriverInit.getCurrentDriver());
        registerPage.enterRegisterDetails();
        String accountID=accountPage.OpenNewAccount();
        AccountOverView.verifyAccount(accountID);
    }

    @Test
    public void RegisterAccount2() {
        TestData.readTestData("TC001");
        RegisterPage registerPage = new RegisterPage(DriverInit.getCurrentDriver());
        registerPage.enterRegisterDetails();
    }

    @Test
    public void RegisterAccoun3() {
        TestData.readTestData("TC001");
        RegisterPage registerPage = new RegisterPage(DriverInit.getCurrentDriver());
        registerPage.enterRegisterDetails();
    }

    @Test
    public void RegisterAccoun4() {
        TestData.readTestData("TC001");
        RegisterPage registerPage = new RegisterPage(DriverInit.getCurrentDriver());
        registerPage.enterRegisterDetails();
    }

    @AfterMethod
    public void afterMethod() {
        CommonMethods.takeScreenshot();
        DriverInit.closeDriver();
    }

}
