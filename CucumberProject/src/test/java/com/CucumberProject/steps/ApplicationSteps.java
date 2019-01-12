package com.CucumberProject.steps;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.CucumberProject.webDriver.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ApplicationSteps {
	
	WebConnector con;
	public ApplicationSteps(WebConnector con)
	{
		this.con=con;
	}
	
	@Then("^Login should be (.*)$")
	public void ValidateLogin(String ExpectedResult)
	{
		con.ValidateLogin(ExpectedResult);
	}
	
	@And("^I Login inside application$")
	public void login(Map<String,String> data)
	{
		System.out.println(data.get("Username"));
		System.out.println(data.get("Password"));
		con.Login(data.get("Username"),data.get("Password"));
	}
}
