Feature: Overview Page
  As a user, I want to complete my order successfully so that I can purchase items in my cart.

  Scenario: User successfully completes the checkout process
    Given the user is on the Checkout Overview page-overview testing
    When the user reviews the items in the cart-overview testing
    And the user clicks on the "Finish" button-overview testing
    Then the order is successfully placed-overview testing
    And the user is redirected to the "Thank You" page-overview testing
    And the "Thank You" page displays the message "Thank you for your order!"-overview testing

  Scenario: User cancels the checkout process
    Given the user is on the Checkout Overview page-overview testing
    When the user clicks on the "Cancel" button-overview testing
    Then the user is redirected to the cart page-overview testing
    And the cart page displays all previously added items-overview testing
