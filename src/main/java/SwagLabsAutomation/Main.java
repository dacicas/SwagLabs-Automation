package SwagLabsAutomation;

import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.drivers.pages.ShopPage;
import SwagLabsAutomation.drivers.pages.SinginPage;
import SwagLabsAutomation.utils.FrameworkProperties;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");
        SinginPage singInPage = new SinginPage();
        singInPage.login();
        //driver.quit();
        String expectedTitle = "Products";
        ShopPage shopPage = new ShopPage();
        if(shopPage.getTitle().equals(expectedTitle)){
            System.out.println("Found Title : "+ expectedTitle);
        }else{
            System.out.println("Shit wrong title");
        }
        driver.quit();
    }
}