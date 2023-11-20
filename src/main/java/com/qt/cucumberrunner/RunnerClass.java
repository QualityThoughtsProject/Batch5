package com.qt.cucumberrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "FeatureFile",
        glue = "com.qt.cucumber",
        plugin = {"pretty","html:target/Cucumber-Report/TestResult.html"},
        monochrome = true
)
public class RunnerClass {
}
