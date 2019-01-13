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
@Portfolio
Feature: Title of your feature
  I want to use this template for my feature file

Background:
	  Given I open Mozilla
    And I navigate to loginURL
    And I Login inside application
    |Username		|	ashishthakur1983|
    |Password		|	pass@1234| 


  @createPortfolio
  Scenario: Creating a Portfolio
    And I click create_PortfolioID and wait for portfolioName_id
    And I clear portfolioName_id
    And I type Port12124 in portfolioName_id field
    And I click on portfolioSubmit_id button

  #@deletePortfolio
  #Scenario: Deleting a Portfolio	
    #And I want for page to load
    #And I select Port1234 from portfolioselection_id
    #And I want for page to load
    #And I click on deleteportfolio_id
    #When I accept alert

  
