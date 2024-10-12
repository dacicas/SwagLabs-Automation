package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {
    private WebDriver driver;

    public ShopPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
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
    public void clickHamburgerButton(){
        hamburgerMenu.click();
    }
    public void clickSorter(){
        sorterDropdown.click();
    }
    public void addToCartBackpack(){
        addToCartBackpack.click();
    }
    public void addToCartBikeLight(){
        addToCartBikeLight.click();
    }
    public void addToCartTShirt(){
        addToCartTShirt.click();
    }
    public void addToCartFleeceJacket(){
        addToCartFleeceJacket.click();
    }
    public void addToCartBabyOnesie(){
        addToCartBabyOnesie.click();
    }
    public void addToCartRedTShirt(){
        addToCartRedTShirt.click();
    }

    public void clickAllItems(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        clickHamburgerButton();
        allItems.click();
    }
    public void clickAboutPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(about));
        clickHamburgerButton();
        about.click();
    }
    public void clickLogout(){
        WebDriverWait waitForHamburgerMenu = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitForHamburgerMenu.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        clickHamburgerButton();
        WebDriverWait waitForLogout = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitForLogout.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }
    public void clickResetAppState(){
        clickHamburgerButton();
        resetAppState.click();
    }
    public void clickCart(){
        shoppingCart.click();
    }
    public String getBackPack(){
        return addToCartBackpack.getText();
    }
    public String getBikeLight(){
        return addToCartBikeLight.getText();
    }
    public String getTShirt(){
        return addToCartTShirt.getText();
    }
    public String getFleeceJacket(){
        return addToCartFleeceJacket.getText();
    }
    public String getBabyOnesie(){
        return addToCartBabyOnesie.getText();
    }
    public String getRedTShirt(){
        return addToCartRedTShirt.getText();
    }
}
