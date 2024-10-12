package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SinginPage {
    private WebDriver driver;

    public SinginPage(){
        driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(id ="login-button")
    private WebElement loginButton;

    public void login(){
        username.click();
        username.sendKeys(Constants.STANDARD_USER);
        password.click();
        password.sendKeys(Constants.PASSWORD_FOR_ALL_USERS);
        loginButton.click();
        System.out.println("Did this happen?");
    }

}
