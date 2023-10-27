package com.qt.pom;

import com.qt.driverfactoty.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AccountOverView {


    public static void verifyAccount(String accountID){
        DriverInit.getCurrentDriver().findElement(By.xpath("//a[text()='Accounts Overview']")).click();
        List<WebElement> table= DriverInit.getCurrentDriver().findElements(By.xpath("//table[@id='accountTable']/tbody/tr"));
        for(int i=1;i<table.size();i++){
            WebElement firstrow=DriverInit.getCurrentDriver().findElement(By.xpath("//table[@id='accountTable']/tbody/tr["+i+"]/td["+i+"]"));
            if(firstrow.getText().equals(accountID)){
                System.out.println("passed "+firstrow.getText());
            }
        }
    }
}
