package com.qt.driverfactoty;
import com.qt.utils.ProjectConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverInit {

    static WebDriver driver;
    public static void initiateDriver(){
        driver=new ChromeDriver();
        driver.get(ProjectConfig.getPropertyValues("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public static WebDriver getCurrentDriver(){
        return driver;
    }

    public static void closeDriver(){
        driver.close();
    }
}
