Feature: Login and Checkout Information Validation

  Scenario: Login with valid credentials and proceed with valid details
    Given the user is on the Sauce Demo login page
    When the user enters "standard_user" as username and "secret_sauce" as password
    And the user clicks the login button
    Then the user should be successfully logged in
    And the user navigates to the checkout page
    When the user enters valid "First Name", "Last Name", and "Postal Code"
    Then the user should successfully proceed to the next step

  Scenario: Display error when the first name field is empty
    Given the user is on the Sauce Demo login page
    When the user enters "standard_user" as username and "secret_sauce" as password
    And the user clicks the login button
    Then the user should be successfully logged in
    And the user navigates to the checkout page
    When the user leaves the "First Name" field empty and enters "Last Name" and "Postal Code"
    And the user clicks the continue button
    Then an error message "Error: First Name is required" should be displayed

  Scenario: Display error when the Last Name field is empty
    Given the user is on the Sauce Demo login page
    When the user enters "error_user" as username and "secret_sauce" as password
    And the user clicks the login button
    Then the user should be successfully logged in
    And the user navigates to the checkout page
    When the user leaves the Last Name field empty and enters "First Name" and "Postal Code"
    And the user clicks the continue button
    Then an error message "Error: Last Name is required" should be displayed
