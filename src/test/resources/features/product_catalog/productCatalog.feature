Feature: Product Catalog and Filtering

  Background:
    Given the user navigates to the SauceDemo login page

  Scenario: Sort products by name from Z to A
    Given the user enters "standard_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    When the user sorts the products by "Name (Z to A)"
    Then the products should be sorted by "Name (Z to A)"
    And the first product should match the "Name (Z to A)" sorting

  Scenario: Sort products by name from A to Z
    Given the user enters "standard_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    When the user sorts the products by "Name (A to Z)"
    Then the products should be sorted by "Name (A to Z)"
    And the first product should match the "Name (A to Z)" sorting

  Scenario: Sort products by price low to high
    Given the user enters "problem_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    When the user sorts the products by "Price (low to high)"
    Then the first price should match the "Price (low to high)" sorting

  Scenario: Sort products by price high to low
    Given the user enters "problem_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    When the user sorts the products by "Price (high to low)"
    Then the first price should match the "Price (high to low)" sorting