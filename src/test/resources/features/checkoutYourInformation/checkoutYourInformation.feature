Feature: Login and Checkout Information Validation

  Scenario: Login with valid credentials and proceed with valid details
    Given the user is on the Sauce Demo login page
    When the user enters "standard_user" as username and "secret_sauce" as password
    And the user clicks the login button
    Then the user should be successfully logged in
    And the user navigates to the checkout page
    When the user enters valid "John", "Doe", and "12345"
    Then the user should successfully proceed to the next step

  Scenario: Display error when the first name field is empty
    Given the user is on the Sauce Demo login page
    When the user enters "standard_user" as username and "secret_sauce" as password
    And the user clicks the login button
    Then the user should be successfully logged in
    And the user navigates to the checkout page
    When the user leaves the "John" field empty and enters "Doe" and "12345"
    And the user clicks the continue button
    Then an error message "Error: First Name is required" should be displayed

  Scenario: Display error when the Last Name field is empty
    Given the user is on the Sauce Demo login page
    When the user enters "error_user" as username and "secret_sauce" as password
    And the user clicks the login button
    Then the user should be successfully logged in
    And the user navigates to the checkout page
    When the user leaves the Last Name field empty and enters "John" and "12345"
    And the user clicks the continue button
    Then an error message "Error: Last Name is required" should be displayed
