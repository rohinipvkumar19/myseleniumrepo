#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Login
Feature: Logging into Rediff Money

  @Login	
  Scenario Outline: Logging into Rediff Money
    Given I open <Browser>
    And I navigate to loginURL
    And I Login inside application
    |Username		|	ashishthakur1983|
    |Password		|	pass@1234|
    Then Login should be <Result>

    Examples:
    |Browser	|Result	|
    |Mozilla	|Success|
    |Chrome		|Success|
    
    
    
    #And I navigate to loginURL
    #And I type ashishthakur1983 in username field
    #And I click on continueButton button
    #And I type pass@1234 in password field
    #And I click on loginSubmit button
    #Then Login should be success
    
