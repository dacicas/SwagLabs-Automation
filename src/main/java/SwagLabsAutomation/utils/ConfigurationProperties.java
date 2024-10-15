package SwagLabsAutomation.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

    @Value("${browser}")
    private String browser;

    public String  getBrowser(){
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
