package starter.actions;

import net.serenitybdd.annotations.Step;
import starter.pageobjects.ProductCartPage;

public class CartAction {
    private ProductCartPage cartPage;

    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        cartPage.openSauceDemo();
    }

    @Step("Enter username {0}")
    public void enterUsername(String username) {
        cartPage.enterUsername(username);
    }

    @Step("Enter password {0}")
    public void enterPassword(String password) {
        cartPage.enterPassword(password);
    }

    @Step("Click button {0}")
    public void clickButton(String button) {
        cartPage.clickButton(button);
    }


    @Step("Add product at position {0} to the cart")
    public void addProductToCart(int position) {
        cartPage.addProductToCart(position);
    }

    @Step("Remove product at position {0} from the cart")
    public void removeProductFromCart(int position) {
        cartPage.removeProductFromCart(position);
    }

    @Step("Get the number of items in the cart")
    public int getNumberOfItemsInCart() {
        return cartPage.getNumberOfItemsInCart();
    }

    @Step("Verify product with name {0} is in the cart")
    public boolean isProductInCart(String productName) {
        return cartPage.isProductInCart(productName);
    }

    @Step("Verify product with name {0} is removed from the cart")
    public boolean isProductRemovedFromCart(String productName) {
        return cartPage.isProductRemovedFromCart(productName);
    }

    @Step("Navigate to cart")
    public void navigateToCart() {
        cartPage.navigateToCart();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        cartPage.enterCheckoutInformation(firstName, lastName, postalCode);
    }

    public void proceedToCheckout() {
        cartPage.clickButton("checkout");
    }

    public void continueToOverview() {
        cartPage.clickButton("continue");
    }

    public String getSubtotal() {
        return cartPage.getCartTotal();
    }

}