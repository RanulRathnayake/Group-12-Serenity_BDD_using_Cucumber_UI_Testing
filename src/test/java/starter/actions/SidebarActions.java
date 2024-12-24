package starter.actions;

import net.serenitybdd.annotations.Step;
import starter.pageobjects.SidebarPage;

public class SidebarActions {

    private SidebarPage sidebarPage;

    @Step("Login to SauceDemo with username {0} and password {1}")
    public void login(String username, String password) {
        sidebarPage.openSauceDemo();
        sidebarPage.enterCredentials(username, password);
        sidebarPage.clickLogin();
    }

    @Step("Open the sidebar menu")
    public void openSidebar() {
        sidebarPage.openSidebar();
    }

    @Step("Select the sidebar option {0}")
    public void selectSidebarOption(String option) {
        sidebarPage.selectSidebarOption(option);
    }

    @Step("Get the current page title")
    public String getPageTitle() {
        return sidebarPage.getPageTitle();
    }

    @Step("Get the current URL")
    public String getCurrentUrl() {
        return sidebarPage.getCurrentUrl();
    }

    @Step("Verify if the login page is displayed")
    public boolean isLoginPageDisplayed() {
        return sidebarPage.isLoginPageDisplayed();
    }

    @Step("Verify if the inventory page is displayed")
    public boolean isInventoryPageDisplayed() {
        return sidebarPage.isInventoryPageDisplayed();
    }

    @Step("Verify if the page displays a 404 error")
    public boolean is404ErrorDisplayed() {
        return sidebarPage.is404ErrorDisplayed();
    }
}
