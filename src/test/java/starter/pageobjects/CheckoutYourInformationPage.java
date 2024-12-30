package starter.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade firstNameField;

    @FindBy(id = "last-name")
    WebElementFacade lastNameField;

    @FindBy(id = "postal-code")
    WebElementFacade postalCodeField;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(css = "span[data-test='title']") // Checkout: Overview title
    WebElementFacade checkoutOverviewTitle;

    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
        waitABit(1000);
    }

    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
        waitABit(1000);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.type(postalCode);
        waitABit(1000);
    }

    public void clearFirstName() {
        firstNameField.clear();
        waitABit(1000);
    }

    public void clearLastName() {
        lastNameField.clear();
        waitABit(1000);
    }

    public void clearPostalCode() {
        postalCodeField.clear();
        waitABit(1000);
    }

    public void clickContinueButton() {
        continueButton.click();
        waitABit(1000);
    }

    public void waitForPageToLoad() {
        waitABit(5000);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isNextPageLoaded() {
        return checkoutOverviewTitle.isPresent();
    }
    @FindBy(className = "error-message-container")
    public WebElement errorMessage;
}
