package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import starter.actions.CheckoutYourInformationActions;
import starter.pageobjects.CheckoutYourInformationPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutYourInformationStepDefinitions {

    @Steps
    CheckoutYourInformationActions checkoutActions;
    CheckoutYourInformationPage checkoutYourInformationPage;

    @Given("the user is on the Sauce Demo login page")
    public void theUserIsOnLoginPage() throws InterruptedException {
        checkoutActions.openLoginPage();
        Thread.sleep(1000);

    }

    @When("the user enters {string} as username and {string} as password")
    public void theUserEntersCredentials(String username, String password) {
        checkoutActions.enterLoginCredentials(username, password);
    }

    @And("the user clicks the login button")
    public void theUserClicksLoginButton() {
        checkoutActions.clickLoginButton();
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeLoggedIn() {
        boolean isLoggedIn = checkoutActions.isLoggedIn();
        assertTrue(isLoggedIn, "Login was not successful");
    }

    @Given("the user navigates to the checkout page")
    public void theUserNavigatesToCheckoutPage() {
        checkoutActions.openCheckoutPage();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        checkoutActions.openCheckoutPage();
    }

    @When("the user enters valid {string}, {string}, and {string}")
    public void theUserEntersValidDetails(String firstName, String lastName, String postalCode) {
        checkoutActions.enterUserDetails(firstName, lastName, postalCode);
    }

    @Then("the user should successfully proceed to the next step")
    public void theUserShouldSuccessfullyProceed() {
        boolean isProceeded = checkoutYourInformationPage.isNextPageLoaded();
        assertTrue(isProceeded, "The user was not able to proceed to the next step");
    }

    @When("the user leaves the {string} field empty and enters {string} and {string}")
    public void userLeavesFirstNameEmpty(String firstName, String lastName, String postalCode) {
        checkoutActions.enterUserDetails("", lastName, postalCode);
    }
    @When("the user leaves the Last Name field empty and enters {string} and {string}")
    public void userLeavesLastNameEmpty(String firstName, String postalCode) {
        checkoutActions.enterUserDetails(firstName, "", postalCode);
    }

    @And("the user clicks the continue button")
    public void userClicksContinueButton() {
        checkoutActions.clickContinueButton();
    }
    @Then("an error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = checkoutActions.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
    }


}
