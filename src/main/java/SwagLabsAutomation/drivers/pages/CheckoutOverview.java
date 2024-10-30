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

    @FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_total_label")
    private WebElement totalPriceWithTax;

    @FindBy(css = "#item_3_title_link > div")
    private WebElement tshirtRed;
    @FindBy(css = "#item_4_title_link > div")
    private WebElement backpack;
    @FindBy(css = "#item_0_title_link > div")
    private WebElement bikeLight;
    @FindBy(css = "#item_1_title_link > div")
    private WebElement boltTshirt;
    @FindBy(css = "#item_5_title_link > div")
    private WebElement fleeceJacket;
    @FindBy(css = "#item_2_title_link > div")
    private WebElement onesie;

    @FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_tax_label")
    private WebElement tax;

    @FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label")
    private WebElement totalPriceWithoutTax;

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
    public  String getTShirtRedText(){
        wait.until(ExpectedConditions.visibilityOf(tshirtRed));
        return tshirtRed.getText();
    }
    public  String getBackpackText(){
        wait.until(ExpectedConditions.visibilityOf(backpack));
        return backpack.getText();
    }
    public  String getBikeLightText(){
        wait.until(ExpectedConditions.visibilityOf(bikeLight));
        return bikeLight.getText();
    }
    public  String getBoltTShirt(){
        wait.until(ExpectedConditions.visibilityOf(boltTshirt));
        return boltTshirt.getText();
    }
    public  String getFleeceJacket(){
        wait.until(ExpectedConditions.visibilityOf(fleeceJacket));
        return fleeceJacket.getText();
    }
    public  String getOnesie(){
        wait.until(ExpectedConditions.visibilityOf(onesie));
        return onesie.getText();
    }
    public String getTotal(){
        wait.until(ExpectedConditions.visibilityOf(totalPriceWithTax));
        return totalPriceWithTax.getText();
    }
    public String getTotalWithoutTax(){
        wait.until(ExpectedConditions.visibilityOf(totalPriceWithoutTax));
        return totalPriceWithoutTax.getText();
    }
    public String isTotalPresent(){
        wait.until(ExpectedConditions.visibilityOf(totalPriceWithTax));
        return totalPriceWithTax.getText();
    }

}
