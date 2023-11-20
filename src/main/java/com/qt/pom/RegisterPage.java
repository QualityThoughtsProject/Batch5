package com.qt.pom;

import com.qt.utils.TestData;
import com.qt.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {

    @FindBy(linkText="Register") public WebElement registerLink;
    @FindBy(xpath="//input[@id='customer.firstName']")public WebElement firstNameTxt;
    @FindBy(xpath="//input[@id='customer.lastName']")public WebElement lastNameTxt;
    @FindBy(xpath="//input[@id='customer.address.street']")public WebElement streetTxt;
    @FindBy(xpath="//input[@id='customer.address.city']")public WebElement cityTxt;
    @FindBy(xpath="//input[@id='customer.address.state']")public WebElement stateTxt;
    @FindBy(xpath="//input[@id='customer.address.zipCode']")public WebElement zipCodeTxt;
    @FindBy(xpath="//input[@id='customer.phoneNumber']")public WebElement phoneNumberTxt;
    @FindBy(xpath="//input[@id='customer.ssn']")public WebElement ssnTxt;
    @FindBy(xpath="//input[@id='customer.username']")public WebElement usernameTxt;
    @FindBy(xpath="//input[@id='customer.password']")public WebElement passwordTxt;
    @FindBy(xpath="//input[@id='repeatedPassword']")public WebElement repeatedPasswordTxt;
    @FindBy(xpath="//input[@value='Register']")public WebElement registerBtn;
    @FindBy(xpath = "//p[@class='smallText']") public WebElement messageLbl;

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void enterRegisterDetails(){
        CommonMethods.clickElement(registerLink);
        CommonMethods.sendTextToElement(firstNameTxt, TestData.getData("First Name")+CommonMethods.getRandomChars());
        CommonMethods.sendTextToElement(lastNameTxt,TestData.getData("Last Name")+CommonMethods.getRandomChars());
        CommonMethods.sendTextToElement(streetTxt,TestData.getData("Address"));
        CommonMethods.sendTextToElement(cityTxt, TestData.getData("City"));
        CommonMethods.sendTextToElement(stateTxt,TestData.getData("State"));
        CommonMethods.sendTextToElement(zipCodeTxt,TestData.getData("Zip Code"));
        CommonMethods.sendTextToElement(phoneNumberTxt, TestData.getData("Phone"));
        CommonMethods.sendTextToElement(ssnTxt,TestData.getData("SSN"));
        CommonMethods.sendTextToElement(usernameTxt,TestData.getData("Username")+CommonMethods.getRandomChars());
        CommonMethods.sendTextToElement(passwordTxt,TestData.getData("Password"));
        CommonMethods.sendTextToElement(repeatedPasswordTxt,TestData.getData("Confirm"));
        CommonMethods.clickElement(registerBtn);
        String textLabel=CommonMethods.getText(messageLbl);
        if(passwordTxt.isEnabled()){

        }else {
            Assert.fail("verification filed");
        }
    }

    public void register(){
        System.out.println("register");
    }
}
