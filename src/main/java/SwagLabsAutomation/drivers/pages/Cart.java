package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    private WebDriver driver;
    private WebDriverWait wait;

    public Cart() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement tittleYourCart;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(css = "#cart_contents_container > div > div.cart_list > div.cart_item")
    private WebElement cartItem;


    public void clickOnContinueShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public void clickCheckOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    public String getTitleYourCart() {
        wait.until(ExpectedConditions.visibilityOf(tittleYourCart));
        return tittleYourCart.getText();
    }

    public boolean isItemPresent() {
        Boolean present = false;
        if (driver.findElements(By.cssSelector("#cart_contents_container > div > div.cart_list > div.cart_item")).size()<1){
            present = false;
        }else {
            present = true;
        }return present;
    }
}




