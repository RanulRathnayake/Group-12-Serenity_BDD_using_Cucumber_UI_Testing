Feature: Product Catalog and Filtering

  Background:
    Given the user navigates to the SauceDemo login page
    And the user enters "standard_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button

  Scenario: Sort products by name from A to Z
    When the user sorts the products by "Name (A to Z)"
    Then the products should be sorted by "Name (A to Z)"
    And the product at position 1 should have name "Sauce Labs Backpack"

  Scenario: Sort products by name from Z to A
    When the user sorts the products by "Name (Z to A)"
    Then the products should be sorted by "Name (Z to A)"
    And the product at position 1 should have name "Test.allTheThings() T-Shirt (Red)"

  Scenario: Sort products by price low to high
    When the user sorts the products by "Price (low to high)"
    Then the product at position 1 should have price "$7.99"

  Scenario: Sort products by price high to low
    When the user sorts the products by "Price (high to low)"
    Then the product at position 1 should have price "$49.99"