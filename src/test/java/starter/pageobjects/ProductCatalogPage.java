package starter.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalogPage extends PageObject {
    @FindBy(id = "user-name")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    @FindBy(className = "product_sort_container")
    private WebElementFacade sortDropdown;

    @FindBy(className = "inventory_item_name")
    private List<WebElementFacade> productNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElementFacade> productPrices;

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
            default:
                throw new IllegalArgumentException("Button " + buttonName + " not found");
        }
    }

    public void selectSortOption(String sortOption) {
        sortDropdown.selectByVisibleText(sortOption);
        waitABit(1000);
    }

    public String getProductNameAtPosition(int position) {
        return position <= productNames.size() ? productNames.get(position - 1).getText() : null;
    }

    public String getProductPriceAtPosition(int position) {
        waitABit(1000);
        return position <= productPrices.size() ? productPrices.get(position - 1).getText() : null;
    }

    public List<String> getAllProductNames() {
        return productNames.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getAllProductPrices() {
        return productPrices.stream()
                .map(element -> Double.parseDouble(element.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    public boolean verifyProductSorting(String sortType) {
        List<String> names = getAllProductNames();
        List<Double> prices = getAllProductPrices();

        switch (sortType) {
            case "Name (A to Z)":
                return isListSortedAlphabetically(names, true);
            case "Name (Z to A)":
                return isListSortedAlphabetically(names, false);
            case "Price (low to high)":
                return isListSortedNumerically(prices, true);
            case "Price (high to low)":
                return isListSortedNumerically(prices, false);
            default:
                return false;
        }
    }

    public String getExpectedFirstProduct(String sortType) {
        List<String> products = getAllProductNames();
        List<Double> prices = getAllProductPrices();

        switch (sortType) {
            case "Name (A to Z)":
                products.sort(String::compareTo);
                return products.get(0);
            case "Name (Z to A)":
                products.sort((a, b) -> b.compareTo(a));
                return products.get(0);
            case "Price (low to high)": {
                int minIndex = 0;
                double minPrice = prices.get(0);
                for (int i = 1; i < prices.size(); i++) {
                    if (prices.get(i) < minPrice) {
                        minPrice = prices.get(i);
                        minIndex = i;
                    }
                }
                return products.get(minIndex);
            }
            case "Price (high to low)": {
                int maxIndex = 0;
                double maxPrice = prices.get(0);
                for (int i = 1; i < prices.size(); i++) {
                    if (prices.get(i) > maxPrice) {
                        maxPrice = prices.get(i);
                        maxIndex = i;
                    }
                }
                return products.get(maxIndex);
            }
            default:
                return null;
        }
    }

    public String getExpectedFirstPrice(String sortType) {
        List<Double> prices = getAllProductPrices();
        Double price;

        switch (sortType) {
            case "Price (low to high)":
                price = prices.stream().min(Double::compareTo).orElse(null);
                break;
            case "Price (high to low)":
                price = prices.stream().max(Double::compareTo).orElse(null);
                break;
            default:
                return null;
        }

        return price != null ? String.format("$%.2f", price) : null;
    }

    public int getNumberOfProducts() {
        return productNames.size();
    }

    private boolean isListSortedAlphabetically(List<String> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            int comparison = list.get(i).compareTo(list.get(i + 1));
            if (ascending && comparison > 0 || !ascending && comparison < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isListSortedNumerically(List<Double> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (ascending && list.get(i) > list.get(i + 1) ||
                    !ascending && list.get(i) < list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}