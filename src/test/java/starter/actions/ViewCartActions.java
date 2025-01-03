package starter.actions;

import net.serenitybdd.annotations.Step;
import starter.pageobjects.ViewCartPage;

public class ViewCartActions {

    private ViewCartPage viewCartPage;

    @Step("Open the Sauce Demo login page")
    public void openLoginPage() {
        viewCartPage.openSauceDemo();
    }

    @Step("Enter username: {0} and password: {1}")
    public void enterLoginCredentials(String username, String password) {
        viewCartPage.enterUsername(username);
        viewCartPage.enterPassword(password);
    }

    @Step("Click the login button")
    public void clickLoginButton() {
        viewCartPage.clickLoginButton();
    }

    @Step("Verify the user is logged in")
    public boolean isLoggedIn() {
        return viewCartPage.isUserLoggedIn();
    }

    @Step("Click the cart button")
    public void openCartPage() {
        viewCartPage.clickCartButton();
    }

    @Step("Verify the cart page is displayed")
    public boolean isCartPageDisplayed() {
        return viewCartPage.isCartPageDisplayed();
    }

    @Step("Select the first available item")
    public void selectFirstAvailableItem() {
        viewCartPage.selectFirstAvailableItem();
    }

    @Step("Add the selected item to the cart")
    public void addItemToCart() {
        viewCartPage.clickAddToCartButton();
    }

    @Step("Verify the cart badge is updated")
    public boolean isCartBadgeUpdated() {
        return viewCartPage.isCartBadgeUpdated();
    }


    @Step("Click the Checkout button")
    public void clickCheckoutButton() {
        viewCartPage.clickCheckoutButton();
    }

    @Step("Verify the checkout information page is displayed")
    public boolean isCheckoutPageDisplayed() {
        return viewCartPage.isCheckoutPageDisplayed();
    }

    @Step("Click the first item in the cart")
    public void clickFirstItemInCart() {
        viewCartPage.clickFirstItemInCart();
    }

    @Step("Verify the item details page is displayed")
    public boolean isItemDetailsPageDisplayed() {
        return viewCartPage.isItemDetailsPageDisplayed();
    }
}