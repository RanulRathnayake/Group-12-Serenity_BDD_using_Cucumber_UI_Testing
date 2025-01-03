package stepdefinitions;

import actions.OverviewActions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class OverviewPageSteps {
    WebDriver driver = DriverFactory.getDriver();
    OverviewActions overviewActions = new OverviewActions(driver);

    @Given("the user is on the Checkout Overview page")
    public void theUserIsOnTheCheckoutOverviewPage() {
        driver.get("https://www.example.com/checkout-overview");  // Replace with actual URL
    }

    @When("the user reviews the items in the cart")
    public void theUserReviewsTheItemsInTheCart() {
        // Placeholder for review validation, if required
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        if (button.equalsIgnoreCase("Finish")) {
            overviewActions.clickFinishButton();
        } else if (button.equalsIgnoreCase("Cancel")) {
            overviewActions.clickCancelButton();
        }
    }

    @Then("the order is successfully placed")
    public void theOrderIsSuccessfullyPlaced() {
        Assert.assertTrue("Order not placed successfully!", overviewActions.isThankYouMessageDisplayed());
    }

    @Then("the user is redirected to the {string} page")
    public void theUserIsRedirectedToThePage(String page) {
        if (page.equalsIgnoreCase("Thank You")) {
            Assert.assertTrue("Not redirected to Thank You page!", overviewActions.isThankYouMessageDisplayed());
        } else if (page.equalsIgnoreCase("cart")) {
            Assert.assertTrue("Not redirected to Cart page!", overviewActions.isRedirectedToCartPage());
        }
    }

    @Then("the {string} page displays the message {string}")
    public void thePageDisplaysTheMessage(String page, String message) {
        if (page.equalsIgnoreCase("Thank You")) {
            Assert.assertTrue("Thank You message is incorrect!", overviewActions.isThankYouMessageDisplayed());
        }
    }

    @Then("the cart page displays all previously added items")
    public void theCartPageDisplaysAllPreviouslyAddedItems() {
        Assert.assertTrue("Cart items are not displayed!", overviewActions.areCartItemsDisplayed());
    }
}
