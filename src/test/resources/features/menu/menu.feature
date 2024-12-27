Feature: Sidebar Menu Navigation

  Scenario: Navigate to "All Items" in the Sidebar Menu as "standard_user"
    Given the user navigates to the SauceDemo login page
    And the user enters "standard_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html"
    When the user opens the sidebar
    And the user clicks on the "All Items" option
    Then the user should see the inventory page


  Scenario: Navigate to "About" Page in the Sidebar Menu as "standard_user"
    Given the user navigates to the SauceDemo login page
    And the user enters "standard_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html"
    When the user opens the sidebar
    And the user clicks on the "About" option
    Then the user should be navigated to the "https://saucelabs.com/" page
    And the page should not display a 404 error


  Scenario: Logout via the Sidebar Menu as "standard_user"
    Given the user navigates to the SauceDemo login page
    And the user enters "standard_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html"
    When the user opens the sidebar
    And the user clicks on the "Logout" option
    Then the user should be logged out and see the login page


  Scenario: Navigate to "About" Page in the Sidebar Menu as "problem_user"
    Given the user navigates to the SauceDemo login page
    And the user enters "problem_user" as the username
    And the user enters "secret_sauce" as the password
    When the user clicks on the "Login" button
    Then the user should be navigated to the inventory page at "https://www.saucedemo.com/inventory.html"
    When the user opens the sidebar
    And the user clicks on the "About" option
    Then the user should be navigated to the "https://saucelabs.com/" page
    And the page should not display a 404 error
