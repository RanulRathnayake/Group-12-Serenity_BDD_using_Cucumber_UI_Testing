package starter.actions;

import net.serenitybdd.annotations.Step;
import starter.pageobjects.CheckoutOverviewPage;

public class CheckoutOverviewActions {

    private CheckoutOverviewPage overviewPage;

    @Step("Click the Finish button to complete the checkout")
    public void clickFinishButton() {
        overviewPage.clickFinish();
    }

    @Step("Click the Cancel button to return to the cart page")
    public void clickCancelButton() {
        overviewPage.clickCancel();
    }

    @Step("Verify that the Thank You page is displayed")
    public boolean isThankYouPageDisplayed() {
        return overviewPage.isThankYouPageDisplayed();
    }

    @Step("Verify that the Thank You message is displayed")
    public boolean isThankYouMessageDisplayed() {
        return overviewPage.isThankYouMessageDisplayed();
    }

    @Step("Verify that the user is redirected to the Cart page")
    public boolean isRedirectedToCartPage() {
        return overviewPage.isCartPageDisplayed();
    }

    @Step("Verify that cart items are displayed")
    public boolean areCartItemsDisplayed() {
        return overviewPage.areCartItemsDisplayed();
    }
}
