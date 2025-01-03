package starter.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    @FindBy(id = "shopping_cart_container")
    private WebElementFacade cartButton;

    @FindBy(className = "cart_list")
    private WebElementFacade cartList;

    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

    @FindBy(className = "inventory_item_name")
    private WebElementFacade firstItemInCart;

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
        return cartButton.isDisplayed();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public boolean isCartPageDisplayed() {
        return cartList.isDisplayed();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public boolean isCheckoutPageDisplayed() {
        WebElementFacade firstNameField = find(By.id("first-name"));
        return firstNameField.isDisplayed();
    }

    public void clickFirstItemInCart() {
        firstItemInCart.click();
    }

    public boolean isItemDetailsPageDisplayed() {
        WebElementFacade itemTitle = find(By.className("inventory_details_name"));
        return itemTitle.isDisplayed();
    }

    @FindBy(className = "inventory_item")
    private WebElementFacade firstInventoryItem;

    @FindBy(className = "btn_inventory")
    private WebElementFacade addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElementFacade cartBadge;

    // Select the first available item from the inventory
    public void selectFirstAvailableItem() {
        firstInventoryItem.click();
    }

    // Click the "Add to Cart" button for the selected item
    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    // Check if the cart badge is updated (non-empty and visible)
    public boolean isCartBadgeUpdated() {
        return cartBadge.isDisplayed() && !cartBadge.getText().isEmpty();
    }


}
