package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverview {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutOverview() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement checkoutOverview;

    @FindBy(css = "#checkout_summary_container > div > div.cart_list > div.cart_item")
    private WebElement checkoutItemAvailabel;

    @FindBy(id="cancel")
    private WebElement cancelButton;

    @FindBy(id="finish")
    private WebElement finishButton;

    public String getCheckoutOverviewText() {
        wait.until(ExpectedConditions.visibilityOf(checkoutOverview));
        return checkoutOverview.getText();
    }

    public String checkoutItemAvailabel() {
        wait.until(ExpectedConditions.visibilityOf(checkoutItemAvailabel));
        return checkoutItemAvailabel.getText();
    }

    public void clickCancelButton(){
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
    }
    public void clickFinishButton(){
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        finishButton.click();
    }

}
