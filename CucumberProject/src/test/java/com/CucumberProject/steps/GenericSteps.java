package com.CucumberProject.steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.CucumberProject.webDriver.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GenericSteps {
	
	WebConnector con;
	
	public GenericSteps(WebConnector con)
	{
		this.con=con;
	}
	
	@Before
	public void before(Scenario s)
	{
		System.out.println("---------Before-------------"+s.getName());
		con.initReports(s.getName());
	}
	
	@After
	public void after()
	{
		System.out.println("--------After--------------");
		con.quit();
	}
	
	@Given("^I open (.*)$")
	public void open_Browser(String browserName)
	{
		con.infoLog("Opening Browser "+browserName);
		con.openBrowser(browserName);
	}
	
	@And("^I navigate to (.*)$")
	public void navigate_to_url(String url)
	{
		con.infoLog("Navigating to "+url);
		con.navigate(url);
	}
	
	 @And("^I type (.*) in (.*) field$")
	 public void type(String username,String xpath)
	 {
		 con.infoLog("Typing in "+username+ " in "+xpath+" field");
		 con.type(xpath, username);
	 }
	 
	 @And("^I clear (.*)$")
		public void clear(String locatorKey) {
			con.infoLog("Clearing in "+locatorKey);
			con.clear(locatorKey);
		}
	 
	 @And("^I click on (.*) button$")
	 public void click_continue(String xpath)
	 {
		 con.infoLog("Clicking on "+xpath);
		 con.click(xpath);
	 }
	 
	 @And("^I click (.*) and wait for (.*)$")
		public void clickAndWait(String src,String target) {
			con.infoLog("Clicking on "+ src);
			con.clickAndWait(src, target, 60);	
		}
		@And("I select (.*) from (.*)")
		public void select(String data,String locatorKey) {
			con.infoLog("Selecting from "+ locatorKey);
			con.select(locatorKey,data);
		}

		@And("^I wait for page to load$")
		public void waitForPageToLoad() {
			con.waitForPageToLoad();
		}
		
		@When("^I accept alert$")
		public void iAcceptAlert() {
			con.acceptAlertIfPresent();
		}
}
