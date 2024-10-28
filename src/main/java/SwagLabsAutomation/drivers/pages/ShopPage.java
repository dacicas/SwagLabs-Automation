package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

public class ShopPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ShopPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement titleProducts;
    @FindBy(id = "react-burger-menu-btn")
    private  WebElement hamburgerMenu;
    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCart;
    @FindBy(css = "#header_container > div.header_secondary_container > div > span > select")
    private WebElement sorterDropdown;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpack;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCartTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartFleeceJacket;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addToCartBabyOnesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement addToCartRedTShirt;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItems;
    @FindBy(id = "about_sidebar_link")
    private WebElement about;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;
    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppState;

    public String getTitle(){
        String title = titleProducts.getText();
        return title;
    }
    public WebElement returnBackpack(){
        return addToCartBackpack;
    }
    public void clickHamburgerButton(){
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        hamburgerMenu.click();
    }
    public void clickSorter(){
        wait.until(ExpectedConditions.elementToBeClickable(sorterDropdown));
        sorterDropdown.click();
    }
    public void addToCartBackpack(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBackpack));
        addToCartBackpack.click();
    }
    public void addToCartBikeLight(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBikeLight));
        addToCartBikeLight.click();
    }
    public void addToCartTShirt(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartTShirt));
        addToCartTShirt.click();
    }
    public void addToCartFleeceJacket(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartFleeceJacket));
        addToCartFleeceJacket.click();
    }
    public void addToCartBabyOnesie(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBabyOnesie));
        addToCartBabyOnesie.click();
    }
    public void addToCartRedTShirt(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartRedTShirt));
        addToCartRedTShirt.click();
    }

    public void clickAllItems(){
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        clickHamburgerButton();
        wait.until(ExpectedConditions.elementToBeClickable(allItems));
        allItems.click();
    }
    public void clickAboutPage(){
        wait.until(ExpectedConditions.elementToBeClickable(about));
        clickHamburgerButton();
        wait.until(ExpectedConditions.elementToBeClickable(about));
        about.click();
    }
    public void clickLogout(){

        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        clickHamburgerButton();
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }
    public void clickResetAppState(){
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        clickHamburgerButton();
        wait.until(ExpectedConditions.elementToBeClickable(resetAppState));
        resetAppState.click();
    }
    public void clickCart(){
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();
    }
    public String getBackPack(){
        wait.until(ExpectedConditions.visibilityOf(addToCartBackpack));
        return addToCartBackpack.getText();
    }
    public String getBikeLight(){
        wait.until(ExpectedConditions.visibilityOf(addToCartBikeLight));
        return addToCartBikeLight.getText();
    }
    public String getTShirt(){
        wait.until(ExpectedConditions.visibilityOf(addToCartTShirt));
        return addToCartTShirt.getText();
    }
    public String getFleeceJacket(){
        wait.until(ExpectedConditions.visibilityOf(addToCartFleeceJacket));
        return addToCartFleeceJacket.getText();
    }
    public String getBabyOnesie(){
        wait.until(ExpectedConditions.visibilityOf(addToCartBabyOnesie));
        return addToCartBabyOnesie.getText();
    }
    public String getRedTShirt(){
        wait.until(ExpectedConditions.visibilityOf(addToCartRedTShirt));
        return addToCartRedTShirt.getText();
    }

}
