package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import starter.actions.ProductCatalogAction;

public class ProductCatalogStepDefinitions {

    @Steps
    ProductCatalogAction productCatalogAction;

    @Given("the user navigates to the SauceDemo login page")
    public void the_user_navigates_to_the_sauce_demo_login_page() {
        productCatalogAction.navigateToLoginPage();
    }

    @Given("the user enters {string} as the username")
    public void the_user_enters_as_the_username(String username) {
        productCatalogAction.enterUsername(username);
    }

    @Given("the user enters {string} as the password")
    public void the_user_enters_as_the_password(String password) {
        productCatalogAction.enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String button) {
        productCatalogAction.clickButton(button);
    }

    @When("the user sorts the products by {string}")
    public void userSortsProductsBy(String sortOption) {
        productCatalogAction.sortProductsBy(sortOption);
    }

    @Then("the products should be sorted by {string}")
    public void productsShouldBeSortedBy(String sortType) {
        Assert.assertTrue("Products are not correctly sorted!",
                productCatalogAction.isProductSortingCorrect(sortType));
    }

    @Then("the first product should match the {string} sorting")
    public void verifyFirstProductAfterSorting(String sortType) {
        String expectedProduct = productCatalogAction.getExpectedFirstProduct(sortType);
        String actualProduct = productCatalogAction.getProductNameAtPosition(1);
        Assert.assertEquals("First product doesn't match expected sorting order!",
                expectedProduct, actualProduct);
    }

    @Then("the first price should match the {string} sorting")
    public void verifyFirstPriceAfterSorting(String sortType) {
        String expectedPrice = productCatalogAction.getExpectedFirstPrice(sortType);
        String actualPrice = productCatalogAction.getProductPriceAtPosition(1);
        Assert.assertEquals("First price doesn't match expected sorting order!",
                expectedPrice, actualPrice);
    }
}