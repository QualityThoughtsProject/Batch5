package com.qt.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    @Given("user launch the application")
    public void user_launch_the_application() {
        System.out.println("user launch the application");
    }
    @When("user enteres the user name and password")
    public void user_enteres_the_user_name_and_password() {
        System.out.println("user enteres the user name and password");
    }
    @Then("user should be abe to see home page")
    public void user_should_be_abe_to_see_home_page() {
        System.out.println("\"user should be abe to see home page");
        Assert.fail();
    }
}
