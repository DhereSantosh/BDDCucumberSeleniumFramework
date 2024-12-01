Feature: Login Functionality for OrangeHRM Website

	As a user of the OrangeHRM website
  	I want to be able to log in with my account
  	So that I can access my account-related features and manage my operations
  	
  	Background:
    Given I am on the OrangeHRM login page
    
    Scenario: Successful login with valid credentials
	    Given I have entered a valid username and password
	    When I click on the login button
	    Then I should be logged in successfully
	
	Scenario Outline: Unsuccessful login with invalid or empty credentials
	    Given I have entered invalid "<username>" and "<password>"
	    When I click on the login button
	    Then I should see an error message indicating "<error_message>"

    Examples:
      | username | password | error_message                                         |
      | admiin   | Admin123 | Invalid credentials |
      | admiin   | Admin12 | Invalid credentials |
    
      
    Scenario: Navigating to the forgotten password page
	    When I click on the "Forgotten Password" link
	    Then I should be redirected to the password reset page