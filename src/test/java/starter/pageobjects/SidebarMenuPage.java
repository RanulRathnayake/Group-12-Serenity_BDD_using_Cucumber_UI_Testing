package starter.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SidebarMenuPage extends PageObject {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By sidebarButton = By.id("react-burger-menu-btn");
    private By logoutOption = By.id("logout_sidebar_link");
    private By allItemsOption = By.id("inventory_sidebar_link");
    private By aboutOption = By.id("about_sidebar_link");
    private By inventoryContainer = By.id("inventory_container");
    private By errorMessage = By.tagName("body");

    public void openSauceDemo() {openUrl("https://www.saucedemo.com");}

    public void enterUsername(String username) {
        $(usernameField).type(username);
        waitABit(1000);
    }

    public void enterPassword(String password) {
        $(passwordField).type(password);
        waitABit(1000);
    }

    public void clickButton(String button) {
        switch (button.toLowerCase()) {
            case "login":
                $(loginButton).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid button: " + button);
        }
        waitABit(1500);
    }

    public void openSidebar() {
        $(sidebarButton).click();
        waitABit(1500);
    }

    public void selectSidebarOption(String option) {
        switch (option.toLowerCase()) {
            case "all items":
                $(allItemsOption).click();
                waitABit(1000);
                break;
            case "about":
                $(aboutOption).click();
                waitABit(1000);
                break;
            case "logout":
                $(logoutOption).click();
                waitABit(1000);
                break;
            default:
                throw new IllegalArgumentException("Invalid sidebar option: " + option);
        }
    }

    public String getCurrentUrl() {return getDriver().getCurrentUrl();}

    public boolean isInventoryPageDisplayed() {
        return $(inventoryContainer).isDisplayed();
    }

    public boolean isLoginPageDisplayed() {
        return $(loginButton).isDisplayed();
    }

    public boolean is404ErrorDisplayed() {
        return $(errorMessage).getText().contains("404");
    }
}
