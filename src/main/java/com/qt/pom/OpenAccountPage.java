package com.qt.pom;

import com.qt.utils.CommonMethods;
import com.qt.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OpenAccountPage {

    @FindBy(xpath = "//a[text()='Open New Account']")public WebElement openNewAccountLink;
    @FindBy(xpath = "//select[@id='type']") public WebElement typeOfAccountDropDown;
    @FindBy(xpath = "//select[@id='type']") public List<WebElement> typeOfAccountDropDownList;
    @FindBy(id = "fromAccountId") public WebElement fromAccountIdDropDown;
    @FindBy(xpath = "//input[@value='Open New Account']") public WebElement openNewAccountBtn;
    @FindBy(id ="newAccountId") public WebElement accountID;

    public OpenAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String OpenNewAccount(){
        try {
            CommonMethods.clickElement(openNewAccountLink);
            CommonMethods.selectValueFromDropDown(typeOfAccountDropDown, TestData.getData("AccountType"));
            CommonMethods.selectValueFromDropDown(fromAccountIdDropDown, TestData.getData("AccountID"));
            CommonMethods.clickElement(openNewAccountBtn);
            Thread.sleep(2000);
            return accountID.getText();
        }catch (Exception e){
            Assert.fail();
            return null;
        }
    }
}
