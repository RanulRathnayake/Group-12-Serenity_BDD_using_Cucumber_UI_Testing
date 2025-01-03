package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OverviewPage {
    WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")  // Replace with actual locator
    public WebElement finishButton;

    @FindBy(id = "cancel")  // Replace with actual locator
    public WebElement cancelButton;

    @FindBy(xpath = "//h2[contains(text(), 'Thank you for your order!')]")  // Replace with actual locator
    public WebElement thankYouMessage;

    @FindBy(css = ".cart_item")  // Replace with actual locator
    public List<WebElement> cartItems;

    @FindBy(xpath = "//div[contains(text(), 'Your Cart')]")  // Replace with actual locator
    public WebElement cartPageTitle;
}
