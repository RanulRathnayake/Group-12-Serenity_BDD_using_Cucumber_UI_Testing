Feature: Product Cart Management

  Background:
    Given the user navigates to the SauceDemo login page

  Scenario: Add a product to the cart
    Given the user enters "problem_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    And I add the product at position 1 to the cart
    Then I should see 1 items in the cart
    And The product with name "Sauce Labs Backpack" should be in the cart

  Scenario: Remove a product from the cart
    Given the user enters "problem_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    And I navigate to the cart
    When I remove the product at position 1 from the cart
    Then I should see 0 items in the cart
    And The product with name "Sauce Labs Backpack" should be removed from the cart

  Scenario: Validate cart total after adding a product
    Given the user enters "problem_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    And I add the product at position 1 to the cart
    And I navigate to the cart
    And I proceed to checkout
    And I enter the following checkout information:
      | First Name | Last Name | Postal Code |
      | John       | Doe       | 12345       |
    And I continue to the overview page
    Then The total price in the cart should be "$29.99"