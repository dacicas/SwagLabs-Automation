package SwagLabsAutomation;

import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.drivers.pages.Cart;
import SwagLabsAutomation.drivers.pages.ShopPage;
import SwagLabsAutomation.drivers.pages.SinginPage;
import SwagLabsAutomation.utils.FrameworkProperties;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        //TODO:
        //Add cucumber
        //ADD BDD testing to the project
        //Remove this :
        /*FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");
        SinginPage singInPage = new SinginPage();
        singInPage.login();
        String expectedTitle = "Products";
        ShopPage shopPage = new ShopPage();
        Cart newCart = new Cart();
        if(shopPage.getTitle().equals(expectedTitle)){
            System.out.println("Found Title : "+ expectedTitle);
        }else{
            System.out.println("Shit wrong title");
        }
        shopPage.addToCartBackpack();
        shopPage.clickCart();
        if (newCart.isItemPresent(shopPage.returnBackpack())){
            System.out.println("There are items in cart");
        }else {
            System.out.println("Cart is empty");
        }

        driver.quit();
    }*/
    }
}
