Feature: Sidebar Menu Navigation

  Scenario: Navigate to "All Items" in the Sidebar Menu as "standard_user" - Sidebar Testing
    Given the user navigates to the SauceDemo login page - Sidebar Testing
    And the user enters "standard_user" as the username - Sidebar Testing
    And the user enters "secret_sauce" as the password - Sidebar Testing
    When the user clicks on the "Login" button - Sidebar Testing
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html" - Sidebar Testing
    When the user opens the sidebar - Sidebar Testing
    And the user clicks on the "All Items" option - Sidebar Testing
    Then the user should see the inventory page - Sidebar Testing


  Scenario: Navigate to "About" Page in the Sidebar Menu as "standard_user" - Sidebar Testing
    Given the user navigates to the SauceDemo login page - Sidebar Testing
    And the user enters "standard_user" as the username - Sidebar Testing
    And the user enters "secret_sauce" as the password - Sidebar Testing
    When the user clicks on the "Login" button - Sidebar Testing
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html" - Sidebar Testing
    When the user opens the sidebar - Sidebar Testing
    And the user clicks on the "About" option - Sidebar Testing
    Then the user should be navigated to the "https://saucelabs.com/" page - Sidebar Testing
    And the page should not display a 404 error - Sidebar Testing


  Scenario: Logout via the Sidebar Menu as "standard_user" - Sidebar Testing
    Given the user navigates to the SauceDemo login page - Sidebar Testing
    And the user enters "standard_user" as the username - Sidebar Testing
    And the user enters "secret_sauce" as the password - Sidebar Testing
    When the user clicks on the "Login" button - Sidebar Testing
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html" - Sidebar Testing
    When the user opens the sidebar - Sidebar Testing
    And the user clicks on the "Logout" option - Sidebar Testing
    Then the user should be logged out and see the login page - Sidebar Testing


  Scenario: Navigate to "About" Page in the Sidebar Menu as "problem_user" - Sidebar Testing
    Given the user navigates to the SauceDemo login page - Sidebar Testing
    And the user enters "problem_user" as the username - Sidebar Testing
    And the user enters "secret_sauce" as the password - Sidebar Testing
    When the user clicks on the "Login" button - Sidebar Testing
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html" - Sidebar Testing
    When the user opens the sidebar - Sidebar Testing
    And the user clicks on the "About" option - Sidebar Testing
    Then the user should be navigated to the "https://saucelabs.com/" page - Sidebar Testing
    And the page should not display a 404 error - Sidebar Testing
