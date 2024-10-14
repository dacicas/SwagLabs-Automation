package SwagLabsAutomation.drivers.pages;

import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
    private WebDriver driver;
    private WebDriverWait wait;
    public Checkout() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 15);
    }
    @FindBy(id= "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement titleCheckout;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "continue")
    private WebElement continueButton;


    @FindBy(css="#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    private WebElement errorMandatoryFields;

    public void inputFirstName(){
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        firstNameInput.click();
        firstNameInput.sendKeys(Constants.FIRST_NAME);
    }
    public void inputLastName(){
        wait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
        lastNameInput.click();
        lastNameInput.sendKeys(Constants.LAST_NAME);
    }
    public void inputPostalCode(){
        wait.until(ExpectedConditions.elementToBeClickable(postalCodeInput));
        postalCodeInput.click();
        postalCodeInput.sendKeys(Constants.ZIP_CODE);
    }
}
