package automation;

import SwagLabsAutomation.config.RunFrameworkConfiguration;
import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.drivers.pages.*;
import SwagLabsAutomation.utils.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

@CucumberContextConfiguration
@ContextConfiguration(classes = RunFrameworkConfiguration.class)
public class SingInDefinition {
    private WebDriver driver;
    private SinginPage singinPage;
    private ShopPage shopPage;
    private Cart cart;
    private Checkout checkout;
    private CheckoutOverview checkoutOverview;
    private CheckoutComplete checkoutComplete;
    ExtentTest test;
    static ExtentReports report = new ExtentReports("report/TestReport.html");

    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects(){
        DriverSingleton.getInstance(configurationProperties.getBrowser());
        singinPage = new SinginPage();
        shopPage = new ShopPage();
        cart = new Cart();
        checkout = new Checkout();
        checkoutOverview = new CheckoutOverview();
        checkoutComplete = new CheckoutComplete();
        TestCases[] tests = TestCases.values();
        test = report.startTest(tests[Utils.testCount].getTestName());
        Log.getLogData(Log.class.getName());
        Log.startTest(tests[Utils.testCount].getTestName());
        Utils.testCount++;
    }
    @After
    public void closeDriver() throws InterruptedException {
        report.endTest(test);
        report.flush();
        DriverSingleton.closeObjectInstance();
        sleep(Duration.ofSeconds(3));
    }
    @Given("^I go to the Website")
    public void i_go_to_website(){
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        Log.info("Navigating to " + Constants.URL);
        test.log(LogStatus.PASS, "Navigating to " + Constants.URL);
    }
    @When("^I specify my credentials and click login")
    public void i_specify_my_credentials_and_click_login(){
        singinPage.login();
        test.log(LogStatus.PASS, "Sign In button has been clicked");
    }

    @Then("^I can login to website")
    public void i_can_login_to_the_website(){
        if (shopPage.getTitle().equals(Constants.TITLE_PRODUCTS)){
            test.log(LogStatus.PASS, "The authentication is successful");
        }else{
            test.log(LogStatus.FAIL, "Authentication is not successful");
        }
        Assert.assertEquals(shopPage.getTitle(), Constants.TITLE_PRODUCTS);
    }

    @And("^I add several items to cart")
    public void i_add_several_items_to_cart(){
        shopPage.addToCartRedTShirt();
        shopPage.addToCartBackpack();
        shopPage.addToCartBikeLight();
        shopPage.clickCart();
    }
    @And("^I check that those items are added")
    public  void i_check_that_those_items_are_added(){
        if (Constants.TSHIRT.equals(cart.getTShirtRedText())){
            test.log(LogStatus.PASS, "The Red t-shirt is added");
        }else {
            test.log(LogStatus.FAIL, "The Red t-shirt is not added");
        }
        if (Constants.BACKPACK.equals(cart.getBackpackText())){
            test.log(LogStatus.PASS, "The backpack is added");
        }else {
            test.log(LogStatus.FAIL, "The backpack is not added");
        }
        if (Constants.BIKE_LIGHT.equals(cart.getBikeLightText())){
            test.log(LogStatus.PASS, "The bike light is added");
        }else {
            test.log(LogStatus.FAIL, "The bike light is not added");
        }
        Assert.assertEquals(Constants.TSHIRT, cart.getTShirtRedText());
        Assert.assertEquals(Constants.BACKPACK,cart.getBackpackText());
        Assert.assertEquals(Constants.BIKE_LIGHT, cart.getBikeLightText());
    }
    @And("^I go to checkout")
    public void i_go_to_checkout(){
        cart.clickCheckOutButton();
    }
    @And("^I add my details")
    public void i_add_my_details(){
        checkout.inputFirstName();
        checkout.inputLastName();
        checkout.inputPostalCode();
        checkout.clickContinue();
    }
    @And("^I confirm my items are added")
    public void i_confirm_my_items_are_added(){
        Assert.assertNotEquals(checkoutOverview.isTotalPresent(), Constants.NO_ITEMS_IN_CART);
    }
    @Then("^I complete my order")
    public void i_complete_my_order(){
        checkoutOverview.clickFinishButton();
        Assert.assertEquals(checkoutComplete.getThankYouForOrder(), Constants.THANK_YOU_FOR_ORDER);
        Assert.assertEquals(checkoutComplete.getThankYouDescription(), Constants.THANK_YOU_MESSAGE);
    }

}
