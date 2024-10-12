package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
    private WebDriver driver;

    public CheckoutComplete() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement checkoutCompleteTitle;

    @FindBy(css = "#checkout_complete_container > h2")
    private WebElement thankYouForOrder;

    @FindBy(id = "back-to-products")
    private WebElement backToHomeButton;

    @FindBy(css = "#checkout_complete_container > div")
    private WebElement descriptionThankYou;

    public String getThankYouForOrder(){
        return thankYouForOrder.getText();
    }
    public String getCheckoutTitle(){
        return checkoutCompleteTitle.getText();
    }
    public void clickBackToHomeButton(){
        backToHomeButton.click();
    }
    public String getThankYouDescription(){
        return descriptionThankYou.getText();
    }
}
