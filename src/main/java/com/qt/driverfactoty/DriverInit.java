package com.qt.driverfactoty;
import com.qt.utils.ExReporter;
import com.qt.utils.ProjectConfig;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverInit {

   static ThreadLocal<WebDriver>driver=new ThreadLocal<>();
    public static void initiateDriver(String url){
        driver.set(new ChromeDriver());
        driver.get().get(ProjectConfig.getPropertyValues("URL"));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get().manage().window().maximize();
        ExReporter.log(LogStatus.PASS,"Browser Launched "+url);
    }

    public static WebDriver getCurrentDriver(){
        return driver.get();
    }

    public static void closeDriver(){
        driver.get().close();
    }
}
