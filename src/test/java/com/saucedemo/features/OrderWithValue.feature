Feature: Order based on value

  Scenario: Make an order with total between $30 and $60
    Given I am on the SauceDemo login page
    When I enter a valid username and password
    And I click on the login button
    And I add items to get total between $30 and $60
    And I proceed to checkout
    Then the total amount should be between $30 and $60
