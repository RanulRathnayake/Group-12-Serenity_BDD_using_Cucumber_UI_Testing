Feature: Checkout Information Validation

  Scenario: Login with valid credentials and proceed with valid details
    Given the user is on the Sauce Demo login page - checkout
    When the user enters "standard_user" as username and "secret_sauce" as password - checkout
    And the user clicks the login button - checkout
    Then the user should be successfully logged in - checkout
    And the user navigates to the checkout page
    When the user enters valid "John", "Doe", and "12345"
    Then the user should successfully proceed to the next step

  Scenario: Display error when the first name field is empty
    Given the user is on the Sauce Demo login page - checkout
    When the user enters "standard_user" as username and "secret_sauce" as password - checkout
    And the user clicks the login button - checkout
    Then the user should be successfully logged in - checkout
    And the user navigates to the checkout page
    When the user leaves the "John" field empty and enters "Doe" and "12345"
    And the user clicks the continue button
    Then an error message "Error: First Name is required" should be displayed

  Scenario: Verify the Last Name field is editable
    Given the user is on the Sauce Demo login page - checkout
    When the user enters "error_user" as username and "secret_sauce" as password - checkout
    And the user clicks the login button - checkout
    And the user navigates to the checkout page
    Then the Last Name field should be editable
    When the user enters "Doe" in the Last Name field
    Then the Last Name field should accept the value "Doe"
