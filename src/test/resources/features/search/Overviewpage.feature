Feature: Overview Page
  As a user, I want to complete my order successfully so that I can purchase items in my cart.

  Scenario: User successfully completes the checkout process
    Given the user is on the Checkout Overview page
    When the user reviews the items in the cart
    And the user clicks on the "Finish" button
    Then the order is successfully placed
    And the user is redirected to the "Thank You" page
    And the "Thank You" page displays the message "Thank you for your order!"

  Scenario: User cancels the checkout process
    Given the user is on the Checkout Overview page
    When the user clicks on the "Cancel" button
    Then the user is redirected to the cart page
    And the cart page displays all previously added items
