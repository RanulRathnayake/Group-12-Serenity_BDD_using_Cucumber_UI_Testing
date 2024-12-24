Feature: Sidebar Menu

  Scenario: When Logged in as "standard_user", Navigate to "All Items", in the Sidebar Menu
    Given the user is logged into SauceDemo with username "standard_user" and password "secret_sauce"
    When the user opens the sidebar
    And the user selects the "All Items" option
    Then the user should see the inventory page

  Scenario: When Logged in as "standard_user", Navigate to "About" Page, in the Sidebar Menu
    Given the user is logged into SauceDemo with username "standard_user" and password "secret_sauce"
    When the user opens the sidebar
    And the user selects the "About" option
    Then the user should be navigated to the "https://saucelabs.com/" page

  Scenario: When Logged in as "standard_user", Click "Logout" in the Sidebar Menu, and Logout
    Given the user is logged into SauceDemo with username "standard_user" and password "secret_sauce"
    When the user opens the sidebar
    And the user selects the "Logout" option
    Then the user should be logged out

  Scenario: When Logged in as "problem_user", Navigate to "About" Page, in the Sidebar Menu
    Given the user is logged into SauceDemo with username "problem_user" and password "secret_sauce"
    When the user opens the sidebar
    And the user selects the "About" option
    Then the user should be navigated to the "https://saucelabs.com/" page
    And the page should not display a 404 error


