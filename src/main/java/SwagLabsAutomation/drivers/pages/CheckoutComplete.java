package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutComplete {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutComplete() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 15);
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
        wait.until(ExpectedConditions.visibilityOf(thankYouForOrder));
        return thankYouForOrder.getText();
    }
    public String getCheckoutTitle(){
        wait.until(ExpectedConditions.visibilityOf(checkoutCompleteTitle));
        return checkoutCompleteTitle.getText();
    }
    public void clickBackToHomeButton(){
        wait.until(ExpectedConditions.elementToBeClickable(backToHomeButton));
        backToHomeButton.click();
    }
    public String getThankYouDescription(){
        wait.until(ExpectedConditions.visibilityOf(descriptionThankYou));
        return descriptionThankYou.getText();
    }
}
