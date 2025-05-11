Feature: Add and buy items

  Scenario: Add 3 items to basket and buy 2 items
    Given I am on the SauceDemo login page
    When I enter a valid username and password
    And I click on the login button
    And I add three items to the cart
    And I remove 1 item from the cart
    And I proceed to checkout
    Then I should complete the purchase


