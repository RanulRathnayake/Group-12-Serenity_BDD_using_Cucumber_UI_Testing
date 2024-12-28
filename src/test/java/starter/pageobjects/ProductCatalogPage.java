package starter.pageobjects;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductCatalogPage extends PageObject {
    // Login related locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // Product catalog locators
    private By sortDropdown = By.className("product_sort_container");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By productList = By.className("inventory_item");

    public void openSauceDemo() {
        openUrl("https://www.saucedemo.com");
    }

    public void enterUsername(String username) {
        $(usernameField).type(username);
    }

    public void enterPassword(String password) {
        $(passwordField).type(password);
    }

    public void clickButton(String button) {
        switch (button.toLowerCase()) {
            case "login":
                $(loginButton).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid button: " + button);
        }
    }

    public void selectSortOption(String option) {
        $(sortDropdown).selectByVisibleText(option);
    }

    public String getProductNameAtPosition(int position) {
        ListOfWebElementFacades names = findAll(productNames);
        return position <= names.size() ? names.get(position - 1).getText() : "";
    }

    public String getProductPriceAtPosition(int position) {
        ListOfWebElementFacades prices = findAll(productPrices);
        return position <= prices.size() ? prices.get(position - 1).getText() : "";
    }

    public boolean verifyProductSorting(String sortType) {
        ListOfWebElementFacades products = findAll(productNames);
        boolean isSorted = true;

        for (int i = 0; i < products.size() - 1; i++) {
            String current = products.get(i).getText();
            String next = products.get(i + 1).getText();

            if (sortType.equals("Name (A to Z)")) {
                isSorted &= current.compareTo(next) <= 0;
            } else if (sortType.equals("Name (Z to A)")) {
                isSorted &= current.compareTo(next) >= 0;
            }
        }
        return isSorted;
    }

    public int getNumberOfProducts() {
        return findAll(productList).size();
    }
}