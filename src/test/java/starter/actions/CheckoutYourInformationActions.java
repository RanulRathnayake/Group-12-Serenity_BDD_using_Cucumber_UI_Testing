package starter.actions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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
        waitABit(2000);  // Delay after opening the page
    }

    // Enter the username and password for login
    public void enterLoginCredentials(String username, String password) {
        WebElement usernameField = find(By.id("user-name"));
        WebElement passwordField = find(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        waitABit(1000);  // Delay after entering credentials
    }

    // Click the login button
    public void clickLoginButton() {
        find(By.id("login-button")).click();
        waitABit(2000);  // Delay after clicking login
    }

    // Check if the user has logged in successfully
    public boolean isLoggedIn() {
        WebElement productPage = find(By.className("inventory_list"));
        return productPage.isDisplayed();
    }

    // Open the checkout page: click on cart and then checkout button
    public void openCheckoutPage() {
        find(By.id("shopping_cart_container")).click(); // Open the cart
        waitABit(1000);  // Delay after opening the cart
        find(By.id("checkout")).click(); // Proceed to checkout
        waitABit(2000);  // Delay after proceeding to checkout
    }



    // Enter user details like First Name, Last Name, and Postal Code on the checkout page
    public void enterUserDetails(String firstName, String lastName, String postalCode) {
        // Wait for the "first-name" field to be visible before interacting with it
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstNameField.clear(); // Clear the field before entering text
        firstNameField.sendKeys(firstName); // Enter the first name
        System.out.println("Entered First Name: " + firstName);  // Log
        waitABit(1000);  // Optional: Delay after filling the first name

        // Wait for the "last-name" field to be visible before interacting with it
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        lastNameField.clear(); // Clear the field before entering text
        lastNameField.sendKeys(lastName); // Enter the last name
        System.out.println("Entered Last Name: " + lastName);  // Log
        waitABit(1000);  // Optional: Delay after filling the last name

        // Wait for the "postal-code" field to be visible before interacting with it
        WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
        postalCodeField.clear(); // Clear the field before entering text
        postalCodeField.sendKeys(postalCode); // Enter the postal code
        System.out.println("Entered Postal Code: " + postalCode);  // Log
        waitABit(1000);  // Optional: Delay after filling the postal code

        // Click the continue button to proceed to the next step
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueButton.click();
        waitABit(2000);  // Optional: Delay after clicking continue
    }

    public void clickContinueButton() {
        checkoutPage.continueButton.click();
    }

    public String getErrorMessage() {
        return checkoutPage.errorMessage.getText();
    }

}
