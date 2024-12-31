package starter.stepdefinitions;

import net.serenitybdd.annotations.Steps;
import starter.actions.SidebarMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SidebarMenuStepDefinitions {

    @Steps
    SidebarMenuActions sidebarActions;

    @Given("the user navigates to the SauceDemo login page")
    public void the_user_navigates_to_the_sauce_demo_login_page() {
        sidebarActions.navigateToLoginPage();
    }

    @Given("the user enters {string} as the username")
    public void the_user_enters_as_the_username(String username) {
        sidebarActions.enterUsername(username);
    }

    @Given("the user enters {string} as the password")
    public void the_user_enters_as_the_password(String password) {
        sidebarActions.enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String button) {
        sidebarActions.clickButton(button);
    }

    @Then("the user should be navigated to the inventory page at {string}")
    public void the_user_should_be_navigated_to_the_inventory_page(String expectedUrl) {
        Assert.assertEquals("Inventory page URL does not match!", expectedUrl, sidebarActions.getCurrentUrl());
    }

    @When("the user opens the sidebar")
    public void the_user_opens_the_sidebar() {
        sidebarActions.openSidebar();
    }

    @When("the user clicks on the {string} option")
    public void the_user_clicks_on_the_option(String option) {
        sidebarActions.selectSidebarOption(option);
    }

    @Then("the user should see the inventory page")
    public void the_user_should_see_the_inventory_page() {
        Assert.assertTrue("Inventory page is not displayed!", sidebarActions.isInventoryPageDisplayed());
    }

    @Then("the user should be navigated to the {string} page")
    public void the_user_should_be_navigated_to_the_page(String expectedUrl) {
        Assert.assertTrue("User was not navigated to the correct page!", sidebarActions.getCurrentUrl().contains(expectedUrl));
    }

    @Then("the user should be logged out and see the login page")
    public void the_user_should_be_logged_out_and_see_the_login_page() {
        Assert.assertTrue("Logout failed!", sidebarActions.isLoginPageDisplayed());
    }

    @Then("the page should not display a 404 error")
    public void the_page_should_not_display_a_404_error() {
        Assert.assertFalse("404 error is displayed!", sidebarActions.is404ErrorDisplayed());
    }
}
