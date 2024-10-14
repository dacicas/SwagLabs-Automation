package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    private WebDriver driver;
    private WebDriverWait wait;

    public Cart() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 15);
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement tittleYourCart;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id="checkout")
    private WebElement checkoutButton;

    public void clickOnContinueShoppingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }
    public void clickCheckOutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }
    public String getTitleYourCart(){
        wait.until(ExpectedConditions.visibilityOf(tittleYourCart));
        return tittleYourCart.getText();
    }



}
