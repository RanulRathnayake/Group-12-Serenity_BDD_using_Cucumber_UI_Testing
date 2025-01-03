package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import starter.actions.CartAction;

import java.util.Map;

public class CartStepDefinitions {

    @Steps
    CartAction cartAction;

//    @Given("the user navigate to the SauceDemo login page")
//    public void the_user_navigate_to_the_sauce_demo_login_page() {
//        cartAction.navigateToLoginPage();
//    }

//    @Given("the user enters {string} as the username")
//    public void the_user_enters_as_the_username(String username) {
//        cartAction.enterUsername(username);
//    }
//
//    @Given("the user enters {string} as the password")
//    public void the_user_enters_as_the_password(String password) {
//        cartAction.enterPassword(password);
//    }
//
//    @When("the user clicks on the {string} button")
//    public void the_user_click_on_the_button(String button) {
//        cartAction.clickButton(button);
//    }

    @When("I add the product at position {int} to the cart")
    public void iAddTheProductAtPositionToTheCart(int position) {
        cartAction.addProductToCart(position);
    }

    @When("I remove the product at position {int} from the cart")
    public void iRemoveTheProductAtPositionFromTheCart(int position) {
        cartAction.removeProductFromCart(position);
    }

    @Then("I should see {int} items in the cart")
    public void iShouldSeeItemsInTheCart(int expectedItemCount) {
        int actualItemCount = cartAction.getNumberOfItemsInCart();
        Assert.assertEquals("The number of items in the cart is incorrect", expectedItemCount, actualItemCount);
    }

    @Then("The product with name {string} should be in the cart")
    public void theProductWithNameShouldBeInTheCart(String productName) {
        Assert.assertTrue("The product is not in the cart", cartAction.isProductInCart(productName));
    }

    @Then("The product with name {string} should be removed from the cart")
    public void theProductWithNameShouldBeRemovedFromTheCart(String productName) {
        Assert.assertTrue("The product is still in the cart", cartAction.isProductRemovedFromCart(productName));
    }

    @When("I navigate to the cart")
    public void iNavigateToTheCart() {
        cartAction.navigateToCart();
    }

    @When("I proceed to checkout")
    public void proceedToCheckout() {
        cartAction.proceedToCheckout();
    }

    @When("I enter the following checkout information:")
    public void enterCheckoutInformation(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        cartAction.fillCheckoutInformation(
                data.get("First Name"),
                data.get("Last Name"),
                data.get("Postal Code")
        );
    }

    @When("I continue to the overview page")
    public void continueToOverview() {
        cartAction.continueToOverview();
    }


    @Then("The total price in the cart should be {string}")
    public void theTotalPriceInTheCartShouldBe(String expectedTotal) {
        String actualTotal = cartAction.getSubtotal();
        Assert.assertEquals("The cart total is incorrect", expectedTotal, actualTotal);
    }
}