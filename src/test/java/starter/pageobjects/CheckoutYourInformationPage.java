package starter.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    @FindBy(className = "inventory_list")
    private WebElementFacade productPage;

    @FindBy(id = "shopping_cart_container")
    private WebElementFacade cartButton;

    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

    @FindBy(id = "first-name")
    private WebElementFacade firstNameField;

    @FindBy(id = "last-name")
    private WebElementFacade lastNameField;

    @FindBy(id = "postal-code")
    private WebElementFacade postalCodeField;

    @FindBy(id = "continue")
    private WebElementFacade continueButton;

    @FindBy(className = "error-message-container")
    private WebElementFacade errorMessageContainer;

    public void openSauceDemo() {
        openUrl("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        return productPage.isDisplayed();
    }

    public void navigateToCartAndCheckout() {
        cartButton.click();
        checkoutButton.click();
    }

    public void fillUserDetails(String firstName, String lastName, String postalCode) {
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        postalCodeField.type(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }
    public boolean isNextPageDisplayed() {
        WebElementFacade continueButtonElement = find(By.id("continue"));
        return continueButtonElement.isDisplayed();
    }
    public boolean tryToEnterLastName(String lastName) {
        try {
            lastNameField.type(lastName);
            return lastNameField.getValue().equals(lastName);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessageContainer.getText();
    }


}
