Feature: Login to SauceDemo
  As a user of SauceDemo
  I want to be able to log in with valid credentials
  So that I can access my account and view products

  Scenario: Successful login with valid credentials
    Given I am on the SauceDemo login page
    When I enter a valid username and password
    And I click on the login button
    Then I should be redirected to the Products page



