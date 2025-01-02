package starter.actions;

import net.serenitybdd.annotations.Step;
import starter.pageobjects.CheckoutYourInformationPage;

public class CheckoutYourInformationActions {

    private CheckoutYourInformationPage checkoutPage;

    @Step("Open the Sauce Demo login page")
    public void openLoginPage() {
        checkoutPage.openSauceDemo();
    }

    @Step("Enter username: {0} and password: {1}")
    public void enterLoginCredentials(String username, String password) {
        checkoutPage.enterUsername(username);
        checkoutPage.enterPassword(password);
    }

    @Step("Click the login button")
    public void clickLoginButton() {
        checkoutPage.clickLoginButton();
    }

    @Step("Verify the user is logged in")
    public boolean isLoggedIn() {
        return checkoutPage.isUserLoggedIn();
    }

    @Step("Navigate to the checkout page")
    public void openCheckoutPage() {
        checkoutPage.navigateToCartAndCheckout();
    }

    @Step("Enter user details: First Name: {0}, Last Name: {1}, Postal Code: {2}")
    public void enterUserDetails(String firstName, String lastName, String postalCode) {
        checkoutPage.fillUserDetails(firstName, lastName, postalCode);
    }

    @Step("Attempt to enter last name: {0}")
    public boolean isLastNameFieldEditable(String lastName) {
        return checkoutPage.tryToEnterLastName(lastName);
    }

    @Step("Click the continue button")
    public void clickContinueButton() {
        checkoutPage.clickContinue();
    }
    @Step("Verify the next page is loaded")
    public boolean isNextPageLoaded() {
        return checkoutPage.isNextPageDisplayed();
    }

    @Step("Get error message displayed on the page")
    public String getErrorMessage() {
        return checkoutPage.getErrorMessage();
    }

}
