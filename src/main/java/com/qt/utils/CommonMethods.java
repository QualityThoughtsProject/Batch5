package com.qt.utils;

import com.qt.driverfactoty.DriverInit;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CommonMethods {


    public static void clickElement(WebElement ele){
        try{
            ele.click();
            ExReporter.log(LogStatus.INFO,"Element Clicked "+ele);
        }catch(Exception e){
            ExReporter.log(LogStatus.FAIL,"Unable to click Element "+ele);
            Assert.fail("Unable to click "+e.getMessage());
        }
    }

    public static void sendTextToElement(WebElement ele,String text){
        try{
            ele.sendKeys(text);
        }catch (Exception e){
            Assert.fail("Unable to enter text "+e.getMessage());
        }
    }

    public static void sendElementToTextWithJS(WebElement ele,String text){
        JavascriptExecutor js=(JavascriptExecutor) DriverInit.getCurrentDriver();
        js.executeScript("arguments[0].value=’"+text+"'", ele);
    }


    /** This method is used to toke screenshot **/
    public static String takeScreenshot(){
        try {
            File file = ((TakesScreenshot) DriverInit.getCurrentDriver()).getScreenshotAs(OutputType.FILE);
            File filePath = new File(System.getProperty("user.dir") + "//Reports//" + file.getName());
            FileUtils.copyFile(file, filePath);
            return filePath.getName();
        }catch (Exception e){
            System.out.println("Unable to take screenshot");
            return null;
        }
    }

    /** this method is used to select a value from the dropdown **/
    public static void selectValueFromDropDown(WebElement ele,String value){
        try{
            Select sel=new Select(ele);
            sel.selectByVisibleText(value);
        }catch (Exception e){
            System.out.println("Unable to select a value from dropdown "+e.getMessage());
        }
    }

    public static void selectValueFromropdownWithInput(List<WebElement> ele, String value){
        for(WebElement element:ele){
            if(element.getText().equals(value)){
                element.click();
            }
        }
    }

    public static void moveToElement(WebElement ele){
        Actions action=new Actions(DriverInit.getCurrentDriver());
        action.moveToElement(ele).click().build().perform();
    }

    public static void implicitWait(){
        DriverInit.getCurrentDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static String getText(WebElement ele){
        try{
           return ele.getText();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static char getRandomChars(){
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        Random rm=new Random();
        return CHARACTERS.charAt(rm.nextInt(CHARACTERS.length()));
    }

    public static void switchToWindow(){
        String currentWindow=DriverInit.getCurrentDriver().getWindowHandle();
        Set<String>getAllWindows=DriverInit.getCurrentDriver().getWindowHandles();
        for(String childWindow:getAllWindows){
            if(!currentWindow.equals(childWindow)){
                DriverInit.getCurrentDriver().switchTo().window(childWindow);
            }
        }
    }


    /*
     * Method used to swap the window
     */
    public static void swapWindow(int i){
        Set<String> allWindows = DriverInit.getCurrentDriver().getWindowHandles();
        String switchWindow = (String) allWindows.toArray()[i];
        DriverInit.getCurrentDriver().switchTo().window(switchWindow);
        DriverInit.getCurrentDriver().manage().window().maximize();
    }

}
