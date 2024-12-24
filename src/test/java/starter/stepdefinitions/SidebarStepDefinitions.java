package starter.stepdefinitions;

import net.serenitybdd.annotations.Steps;
import starter.actions.SidebarActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SidebarStepDefinitions {

    @Steps
    SidebarActions sidebarActions;

    @Given("the user is logged into SauceDemo with username {string} and password {string}")
    public void the_user_is_logged_into_sauce_demo_with_username_and_password(String username, String password) {
        sidebarActions.login(username, password);
    }

    @When("the user opens the sidebar")
    public void the_user_opens_the_sidebar() {
        sidebarActions.openSidebar();
    }

    @When("the user selects the {string} option")
    public void the_user_selects_the_option(String option) {
        sidebarActions.selectSidebarOption(option);
    }

    @Then("the user should see the {string} page")
    public void the_user_should_see_the_page(String expectedTitle) {
        String actualTitle = sidebarActions.getPageTitle();
        Assert.assertEquals("Page title does not match!", expectedTitle, actualTitle);
    }

    @Then("the user should be navigated to the {string} page")
    public void the_user_should_be_navigated_to_the_page(String expectedUrl) {
        String actualUrl = sidebarActions.getCurrentUrl();
        Assert.assertTrue("User was not navigated to the correct URL!", actualUrl.contains(expectedUrl));
    }

    @Then("the user should see the inventory page")
    public void the_user_should_see_the_inventory_page() {
        // Check the current URL to see if it contains inventory.html
        String actualUrl = sidebarActions.getCurrentUrl();
        Assert.assertTrue("User was not navigated to the inventory page!", actualUrl.contains("inventory.html"));

        // Alternatively, check if a product list is visible
        boolean isInventoryPage = sidebarActions.isInventoryPageDisplayed();
        Assert.assertTrue("Inventory page content is not displayed!", isInventoryPage);    }

    @Then("the user should be logged out")
    public void the_user_should_be_logged_out() {
        Assert.assertTrue("Logout failed!", sidebarActions.isLoginPageDisplayed());
    }

    @Then("the page should not display a 404 error")
    public void the_page_should_not_display_a_404_error() {
        // Verify that the page does not show a 404 error
        boolean is404ErrorDisplayed = sidebarActions.is404ErrorDisplayed();
        Assert.assertFalse("404 error is displayed on the page!", is404ErrorDisplayed);
    }

}
