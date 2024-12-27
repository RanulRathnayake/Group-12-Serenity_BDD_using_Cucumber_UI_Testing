package starter.actions;

import net.serenitybdd.annotations.Step;
import starter.pageobjects.SidebarPage;

public class SidebarActions {

    private SidebarPage sidebarPage;

    @Step("Navigate to SauceDemo login page")
    public void navigateToLoginPage() {
        sidebarPage.openSauceDemo();
    }

    @Step("Enter username {0}")
    public void enterUsername(String username) {
        sidebarPage.enterUsername(username);
    }

    @Step("Enter password {0}")
    public void enterPassword(String password) {
        sidebarPage.enterPassword(password);
    }

    @Step("Click button {0}")
    public void clickButton(String button) {
        sidebarPage.clickButton(button);
    }

    @Step("Open the sidebar menu")
    public void openSidebar() {
        sidebarPage.openSidebar();
    }

    @Step("Select the sidebar option {0}")
    public void selectSidebarOption(String option) {
        sidebarPage.selectSidebarOption(option);
    }

    @Step("Get the current URL")
    public String getCurrentUrl() {
        return sidebarPage.getCurrentUrl();
    }

    @Step("Verify inventory page is displayed")
    public boolean isInventoryPageDisplayed() {
        return sidebarPage.isInventoryPageDisplayed();
    }

    @Step("Verify login page is displayed")
    public boolean isLoginPageDisplayed() {
        return sidebarPage.isLoginPageDisplayed();
    }

    @Step("Verify 404 error is displayed")
    public boolean is404ErrorDisplayed() {
        return sidebarPage.is404ErrorDisplayed();
    }
}
