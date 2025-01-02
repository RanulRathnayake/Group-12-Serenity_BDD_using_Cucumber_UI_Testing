package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import starter.actions.CheckoutYourInformationActions;

import static java.nio.file.Files.find;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class CheckoutYourInformationStepDefinitions {

    @Steps
    CheckoutYourInformationActions checkoutActions;

    @Given("the user is on the Sauce Demo login page - checkout")
    public void theUserIsOnLoginPage() {
        checkoutActions.openLoginPage();
        waitFor(2);
    }

    @When("the user enters {string} as username and {string} as password - checkout")
    public void theUserEntersCredentials(String username, String password) {
        checkoutActions.enterLoginCredentials(username, password);
        waitFor(2);
    }

    @And("the user clicks the login button - checkout")
    public void theUserClicksLoginButton() {
        checkoutActions.clickLoginButton();
        waitFor(2);
    }

    @Then("the user should be successfully logged in - checkout")
    public void theUserShouldBeLoggedIn() {
        assertThat(checkoutActions.isLoggedIn())
                .as("Verify the user is logged in")
                .isTrue();
        waitFor(2);
    }

    @Given("the user navigates to the checkout page")
    public void theUserNavigatesToCheckoutPage() {
        checkoutActions.openCheckoutPage();
        waitFor(2);
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        checkoutActions.openCheckoutPage();
        waitFor(2);
    }

    @When("the user enters valid {string}, {string}, and {string}")
    public void theUserEntersValidDetails(String firstName, String lastName, String postalCode) {
        checkoutActions.enterUserDetails(firstName, lastName, postalCode);
        waitFor(2);
    }

    @Then("the user should successfully proceed to the next step")
    public void theUserShouldSuccessfullyProceedToNextStep() {
        assertThat(checkoutActions.isNextPageLoaded())
                .as("Verify the user proceeded to the next step")
                .isTrue();
        waitFor(2);
    }

    @When("the user leaves the {string} field empty and enters {string} and {string}")
    public void userLeavesFirstNameEmpty(String firstName, String lastName, String postalCode) {
        checkoutActions.enterUserDetails("", lastName, postalCode);
        waitFor(2);
    }

    @When("the user leaves the Last Name field empty and enters {string} and {string}")
    public void userLeavesLastNameEmpty(String firstName, String postalCode) {
        checkoutActions.enterUserDetails(firstName, "", postalCode);
        waitFor(2);
    }

    @And("the user clicks the continue button")
    public void userClicksContinueButton() {
        checkoutActions.clickContinueButton();
        waitFor(2);
    }

    @Then("an error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        assertThat(checkoutActions.getErrorMessage())
                .as("Verify the error message is displayed")
                .isEqualTo(expectedMessage);
        waitFor(2);
    }

    @When("the user tries to enter {string} in the Last Name field")
    public void theUserTriesToEnterInTheLastNameField(String lastName) {
        boolean isEditable = checkoutActions.isLastNameFieldEditable(lastName);
        assertFalse("Bug detected: The Last Name field should be editable but it is not.", isEditable);
    }

    @Then("the test case should fail with a bug report stating {string}")
    public void the_test_case_should_fail_with_a_bug_report_stating(String bugReport) {
        // Log the bug report for reference
        System.out.println("Bug Report: " + bugReport);
        throw new AssertionError("Bug detected: " + bugReport);
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
