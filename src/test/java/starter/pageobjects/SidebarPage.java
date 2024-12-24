package starter.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SidebarPage extends PageObject {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By sidebarButton = By.id("react-burger-menu-btn");
    private By logoutOption = By.id("logout_sidebar_link");
    private By allItemsOption = By.id("inventory_sidebar_link");
    private By aboutOption = By.id("about_sidebar_link");
    private By inventoryContainer = By.id("inventory_container");

    // Open SauceDemo URL
    public void openSauceDemo() {
        openUrl("https://www.saucedemo.com");
        waitABit(1000);  // Delay after opening the page
    }

    // Enter username and password
    public void enterCredentials(String username, String password) {
        $(usernameField).type(username);
        waitABit(1000);  // Delay after entering the username
        $(passwordField).type(password);
        waitABit(1000);  // Delay after entering the password
    }

    // Click the login button
    public void clickLogin() {
        $(loginButton).click();
        waitABit(1000);
    }

    // Open the sidebar menu
    public void openSidebar() {
        $(sidebarButton).click();
        waitABit(1000);
    }

    // Select the sidebar option (All Items, About, Logout)
    public void selectSidebarOption(String option) {
        switch (option.toLowerCase()) {
            case "all items":
                $(allItemsOption).click();
                break;
            case "about":
                $(aboutOption).click();
                break;
            case "logout":
                $(logoutOption).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
        waitABit(1000);
    }

    // Get the page title
    public String getPageTitle() {
        return getTitle();
    }

    // Get the current URL
    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    // Check if the login page is displayed
    public boolean isLoginPageDisplayed() {
        return $(loginButton).isDisplayed();
    }

    // Check if the inventory page is displayed
    public boolean isInventoryPageDisplayed() {
        return $(inventoryContainer).isDisplayed();
    }

    private By errorMessage = By.tagName("body"); // Adjust to locate the 404 error text or element

    public boolean is404ErrorDisplayed() {
        // Check if the page content contains "404" or a similar indicator
        return $(errorMessage).getText().contains("404");
    }

}
