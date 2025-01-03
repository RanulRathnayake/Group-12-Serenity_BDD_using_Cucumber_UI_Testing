Feature: Login and View Cart Page Validation

  Scenario: Login with valid credentials and view the cart page with relevant items
    Given the user is on the Sauce Demo login page - cartPage
    When the user enters "standard_user" as username and "secret_sauce" as password - cartPage
    And the user clicks the login button - cartPage
    Then the user should be successfully logged in - cartPage
    When the user clicks on the cart icon in the top right corner - cartPage
    Then the user navigates to the cart page

  Scenario: Proceed to the checkout page from the cart
    Given the user is on the Sauce Demo login page - cartPage
    When the user enters "standard_user" as username and "secret_sauce" as password - cartPage
    And the user clicks the login button - cartPage
    Then the user should be successfully logged in - cartPage
    When the user clicks on the cart icon in the top right corner - cartPage
    And the user navigates to the cart page
    When the user clicks the "Checkout" button
    Then the user should be navigated to the checkout information page

  Scenario: View item details from the cart
    Given the user is on the Sauce Demo login page - cartPage
    When the user enters "standard_user" as username and "secret_sauce" as password - cartPage
    And the user clicks the login button - cartPage
    Then the user should be successfully logged in - cartPage
    And the user add an item to the cart
    When the user clicks on the cart icon in the top right corner - cartPage
    And the user navigates to the cart page
    When the user clicks on an available item link in the cart page
    Then the user should be navigated to the relevant item's details page
