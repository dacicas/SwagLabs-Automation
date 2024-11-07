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
    public void i_specify_my_credentials_and_click_login() {
        singinPage.login();
        Log.info("Adding username and password and clicking the login button");
    }

    @Then("^I can login to website")
    public void i_can_login_to_the_website(){
        if (shopPage.getTitle().equals(Constants.TITLE_PRODUCTS)){
            test.log(LogStatus.PASS, "The authentication is successful");
            Log.info("Authentication is successful");
        }else{
            test.log(LogStatus.FAIL, "Authentication is not successful");
            Log.fail("Authentication is not successful");
        }
        Assert.assertEquals(shopPage.getTitle(), Constants.TITLE_PRODUCTS);

    }

    @And("^I add several items to cart")
    public void i_add_several_items_to_cart(){
        shopPage.addToCartRedTShirt();
        test.log(LogStatus.PASS, "Red shirt is added to cart");
        Log.info("Red shirt is added to cart");
        shopPage.addToCartBackpack();
        test.log(LogStatus.PASS, "Backpack is added to cart");
        Log.info("Backpack is added to cart");
        shopPage.addToCartBikeLight();
        test.log(LogStatus.PASS, "Bike Light is added to cart");
        Log.info("Bike Light is added to cart");
        shopPage.clickCart();
        test.log(LogStatus.PASS, "CART button is clicked");
        Log.info("CART button is clicked");

    }
    @And("^I check that those items are added")
    public  void i_check_that_those_items_are_added(){
        try {
            if (Constants.TSHIRT.equals(cart.getTShirtRedText())){
                test.log(LogStatus.PASS, "The Red t-shirt is added");
                Log.info("The Red t-shirt is added");
            }else {
                test.log(LogStatus.FAIL, "The Red t-shirt is not added");
                Log.fail("The Red t-shirt is not added");
            }
            if (Constants.BACKPACK.equals(cart.getBackpackText())){
                test.log(LogStatus.PASS, "The backpack is added");
                Log.info("The backpack is added");
            }else {
                test.log(LogStatus.FAIL, "The backpack is not added");
                Log.fail("The backpack is not added");
            }
            if (Constants.BIKE_LIGHT.equals(cart.getBikeLightText())){
                test.log(LogStatus.PASS, "The bike light is added");
                Log.info("The bike light is added");
            }else {
                test.log(LogStatus.FAIL, "The bike light is not added");
                Log.fail("The bike light is not added");
            }
            Assert.assertEquals(Constants.TSHIRT, cart.getTShirtRedText());
            Assert.assertEquals(Constants.BACKPACK,cart.getBackpackText());
            Assert.assertEquals(Constants.BIKE_LIGHT, cart.getBikeLightText());

        } catch (Exception e) {
            test.log(LogStatus.ERROR, "Something was not added");
            Log.fail("Something was not added");
            throw new RuntimeException(e);
        }
    }
    @And("^I go to checkout")
    public void i_go_to_checkout(){
        if(cart.getCheckOutButton().isEmpty()){
            test.log(LogStatus.FAIL, "Checkout button is not visible");
            Log.fail("Checkout button is not visible");
        }else{
            cart.clickCheckOutButton();
            Log.info("Clicked on checkout button");
        }
    }
    @And("^I add my details")
    public void i_add_my_details(){
        checkout.inputFirstName();
        Log.info("Added First Name" + Constants.FIRST_NAME);
        checkout.inputLastName();
        Log.info("Added Last Name" + Constants.LAST_NAME);
        checkout.inputPostalCode();
        Log.info("Added Postal Code" + Constants.ZIP_CODE);
        checkout.clickContinue();
        Log.info("Clicked Continue");
    }

    @And("^I confirm my items are added")
    public void i_confirm_my_items_are_added(){
        Assert.assertNotEquals(checkoutOverview.isTotalPresent(), Constants.NO_ITEMS_IN_CART);
        Log.info("The items in cart are: "+ checkoutOverview.getBackpackText()+", "+checkoutOverview.getBikeLightText()+", "+checkoutOverview.getTShirtRedText());
    }
    @Then("^I complete my order")
    public void i_complete_my_order(){
        checkoutOverview.clickFinishButton();
        Log.info("Finishing the checkout process");
        Assert.assertEquals(checkoutComplete.getThankYouForOrder(), Constants.THANK_YOU_FOR_ORDER);
        Log.info("Thank you for order is displayed");
        Assert.assertEquals(checkoutComplete.getThankYouDescription(), Constants.THANK_YOU_MESSAGE);
        Log.info("Thank you message is displayed");
    }

}
