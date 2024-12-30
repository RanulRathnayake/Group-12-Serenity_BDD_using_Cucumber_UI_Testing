package starter.actions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import starter.pageobjects.CheckoutYourInformationPage;

import java.time.Duration;

public class CheckoutYourInformationActions extends PageObject {

    CheckoutYourInformationPage checkoutPage;
    // Open the Sauce Demo login page
    public void openLoginPage() {
        openUrl("https://www.saucedemo.com/");
        waitABit(2000);
    }

    // Enter the username and password for login
    public void enterLoginCredentials(String username, String password) {
        WebElement usernameField = find(By.id("user-name"));
        WebElement passwordField = find(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        waitABit(1000);
    }

    // Click the login button
    public void clickLoginButton() {
        find(By.id("login-button")).click();
        waitABit(2000);
    }

    // Check if the user has logged in successfully
    public boolean isLoggedIn() {
        WebElement productPage = find(By.className("inventory_list"));
        return productPage.isDisplayed();
    }

    // Open the checkout page: click on cart and then checkout button
    public void openCheckoutPage() {
        find(By.id("shopping_cart_container")).click();
        waitABit(1000);
        find(By.id("checkout")).click();
        waitABit(2000);
    }



    // Enter user details like First Name, Last Name, and Postal Code on the checkout page
    public void enterUserDetails(String firstName, String lastName, String postalCode) {
        // Wait for the "first-name" field to be visible before interacting with it
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        System.out.println("Entered First Name: " + firstName);
        waitABit(1000);

        // Wait for the "last-name" field to be visible before interacting with it
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        System.out.println("Entered Last Name: " + lastName);
        waitABit(1000);

        // Wait for the "postal-code" field to be visible before interacting with it
        WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
        System.out.println("Entered Postal Code: " + postalCode);
        waitABit(1000);

        // Click the continue button to proceed to the next step
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueButton.click();
        waitABit(2000);
    }

    public void clickContinueButton() {
        checkoutPage.continueButton.click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-container")));
        return errorElement.getText();
    }

}
