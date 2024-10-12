package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {
    private WebDriver driver;

    public CheckoutOverview() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement checkoutOverview;

    @FindBy(css = "#checkout_summary_container > div > div.cart_list > div.cart_item")
    private WebElement checkoutItemAvailabel;

    @FindBy(id="cancel")
    private WebElement cancelButton;

    @FindBy(id="finish")
    private WebElement finishButton;



}
