package starter.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ProductCartPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElementFacade addToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElementFacade removeFromCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElementFacade cartItemCount;

    @FindBy(className = "cart_item")
    private List<WebElementFacade> cartItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElementFacade> cartItemNames;

    @FindBy(className = "summary_subtotal_label")
    private WebElementFacade cartTotal;

    @FindBy(className = "shopping_cart_link")
    private WebElementFacade cartIcon;

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

    public void openSauceDemo() {
        openUrl("https://www.saucedemo.com");
        waitABit(1000);
    }

    public void enterUsername(String username) {
        usernameField.type(username);
        waitABit(1000);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
        waitABit(1000);
    }

    public void clickButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "login":
                loginButton.click();
                waitABit(1000);
                break;
            case "checkout":
                checkoutButton.click();
                break;
            case "continue":
                continueButton.click();
                break;
            default:
                throw new IllegalArgumentException("Button " + buttonName + " not found");
        }
    }

    public void addProductToCart(int position) {
        addToCartButton.click();
        waitABit(1000);
    }

    public void removeProductFromCart(int position) {
        removeFromCartButton.click();
        waitABit(1000);
    }

    public int getNumberOfItemsInCart() {
        if (cartItemCount.isPresent()) {
            return Integer.parseInt(cartItemCount.getText());
        }
        return 0;
    }

    public boolean isProductInCart(String productName) {
        return cartItemNames.stream()
                .anyMatch(item -> item.getText().equals(productName));
    }

    public boolean isProductRemovedFromCart(String productName) {
        return !isProductInCart(productName);
    }

    public void navigateToCart() {
        cartIcon.click();
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        postalCodeField.type(postalCode);
    }


    public String getCartTotal() {
        if (cartTotal.isPresent()) {
            String fullText = cartTotal.getText();
            return fullText.split("Item total: ")[1];
        }
        return "$0.00";
    }
}
