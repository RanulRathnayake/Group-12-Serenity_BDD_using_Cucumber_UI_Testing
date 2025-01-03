package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import starter.actions.ViewCartActions;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewCartStepDefinitions {

    @Steps
    ViewCartActions viewCartActions;

    @Given("the user is on the Sauce Demo login page - cartPage")
    public void theUserIsOnLoginPage() {
        viewCartActions.openLoginPage();
        waitFor(2);
    }

    @When("the user enters {string} as username and {string} as password - cartPage")
    public void theUserEntersCredentials(String username, String password) {
        viewCartActions.enterLoginCredentials(username, password);
        waitFor(2);
    }


    @And("the user clicks the login button - cartPage")
    public void theUserClicksLoginButton() {
        viewCartActions.clickLoginButton();
        waitFor(2);
    }

    @Then("the user should be successfully logged in - cartPage")
    public void theUserShouldBeLoggedIn() {
        assertThat(viewCartActions.isLoggedIn())
                .as("Verify the user is logged in")
                .isTrue();
        waitFor(2);
    }

    @When("the user clicks on the cart icon in the top right corner - cartPage")
    public void theUserClicksOnCartIcon() {
        viewCartActions.openCartPage();
        waitFor(2);
    }

    @Then("the user navigates to the cart page")
    public void theUserShouldBeOnCartPage() {
        assertThat(viewCartActions.isCartPageDisplayed())
                .as("Verify the cart page is displayed")
                .isTrue();
        waitFor(2);
    }

    @When("the user clicks the \"Checkout\" button")
    public void theUserClicksCheckoutButton() {
        viewCartActions.clickCheckoutButton();
        waitFor(2);
    }

    @Then("the user should be navigated to the checkout information page")
    public void theUserShouldBeOnCheckoutPage() {
        assertThat(viewCartActions.isCheckoutPageDisplayed())
                .as("Verify the checkout information page is displayed")
                .isTrue();
        waitFor(2);
    }

    @And("the user add an item to the cart")
    public void theUserAddsAnItemToTheCart() {
        viewCartActions.selectFirstAvailableItem();
        viewCartActions.addItemToCart();
        assertThat(viewCartActions.isCartBadgeUpdated())
                .as("Verify the cart badge is updated after adding an item")
                .isTrue();
        waitFor(2);
    }

    @When("the user clicks on an available item link in the cart page")
    public void theUserClicksOnItemLink() {
        viewCartActions.clickFirstItemInCart();
        waitFor(2);
    }

    @Then("the user should be navigated to the relevant item's details page")
    public void theUserShouldBeOnItemDetailsPage() {
        assertThat(viewCartActions.isItemDetailsPageDisplayed())
                .as("Verify the item details page is displayed")
                .isTrue();
        waitFor(2);
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
