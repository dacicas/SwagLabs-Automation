package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Random;
import java.time.Duration;
import java.util.ArrayList;

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


}




