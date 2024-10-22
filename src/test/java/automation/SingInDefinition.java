package automation;

import SwagLabsAutomation.config.RunFrameworkConfiguration;
import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.drivers.pages.*;
import SwagLabsAutomation.utils.ConfigurationProperties;
import SwagLabsAutomation.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

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

    }
    @Given("^I go to the Website")
    public void i_go_to_website(){
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @When("^I specify my credentials and click login")
    public void i_specify_my_credentials_and_click_login(){singinPage.login();}

    @Then("^I can login to website")
    public void i_can_login_to_the_website(){
        Assert.assertEquals(shopPage.getTitle(), Constants.TITLE_PRODUCTS);
    }
}
