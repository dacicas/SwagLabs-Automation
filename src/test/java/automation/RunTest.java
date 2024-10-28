package automation;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        features = {"src/test/resources/feature"},
        glue = {"automation"}
)
public class RunTest {
    @Test
    public void test(){
    //TODO:create a check for items on cart page
    //TODO:PROFIT?
    }
}
