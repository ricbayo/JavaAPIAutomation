
Feature: Exam
  API Automation exam


  Scenario: Validate API response
		Given I want to validate api response
		When I get request from api
		Then I am able to validate that name is "Home & garden"
		And I am able to relist
		And I am able to validate promotion named "Feature" contains description "Better position in category"