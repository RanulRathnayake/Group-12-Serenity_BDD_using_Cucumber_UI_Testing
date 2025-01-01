package starter.actions;

import net.serenitybdd.annotations.Step;
import starter.pageobjects.ProductCatalogPage;

public class ProductCatalogAction {
    private ProductCatalogPage productCatalogPage;

    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        productCatalogPage.openSauceDemo();
    }

    @Step("Enter username {0}")
    public void enterUsername(String username) {
        productCatalogPage.enterUsername(username);
    }

    @Step("Enter password {0}")
    public void enterPassword(String password) {
        productCatalogPage.enterPassword(password);
    }

    @Step("Click button {0}")
    public void clickButton(String button) {
        productCatalogPage.clickButton(button);
    }

    @Step("Sort products by {0}")
    public void sortProductsBy(String sortOption) {
        productCatalogPage.selectSortOption(sortOption);
    }

    @Step("Get product name at position {0}")
    public String getProductNameAtPosition(int position) {
        return productCatalogPage.getProductNameAtPosition(position);
    }

    @Step("Get product price at position {0}")
    public String getProductPriceAtPosition(int position) {
        return productCatalogPage.getProductPriceAtPosition(position);
    }

    @Step("Verify product sorting {0}")
    public boolean isProductSortingCorrect(String sortType) {
        return productCatalogPage.verifyProductSorting(sortType);
    }

    @Step("Get expected first product after sorting by {0}")
    public String getExpectedFirstProduct(String sortType) {
        return productCatalogPage.getExpectedFirstProduct(sortType);
    }

    @Step("Get expected first price after sorting by {0}")
    public String getExpectedFirstPrice(String sortType) {
        return productCatalogPage.getExpectedFirstPrice(sortType);
    }

    @Step("Get number of products displayed")
    public int getNumberOfProducts() {
        return productCatalogPage.getNumberOfProducts();
    }
}