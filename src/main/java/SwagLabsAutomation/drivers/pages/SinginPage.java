package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    /*WebDriverWait wait = new WebDriverWait(driver, 15);*/

    public void login(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(username));
        username.click();
        username.sendKeys(Constants.STANDARD_USER);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.click();
        password.sendKeys(Constants.PASSWORD_FOR_ALL_USERS);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

    }

}
