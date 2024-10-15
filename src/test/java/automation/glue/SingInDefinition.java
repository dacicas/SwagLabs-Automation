package automation.glue;

import SwagLabsAutomation.config.RunFrameworkConfiguration;
import SwagLabsAutomation.drivers.DriverSingleton;
import SwagLabsAutomation.drivers.pages.*;
import SwagLabsAutomation.utils.ConfigurationProperties;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

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
}
