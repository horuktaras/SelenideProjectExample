package th;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import commons.ScreenResolution;
import constants.Property;
import helper.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import th.pages.login.data.User;
import th.utils.listeners.CustomTestNGListener;

@Listeners(CustomTestNGListener.class)
public class BaseTest {

    protected User user;

    @Parameters({"name", "password"})
    @BeforeSuite
    public void setUp(String name, String password) {
        Configuration.baseUrl = PropertyReader.get(Property.BASE_URL);
        Configuration.browserSize = ScreenResolution.currentScreenResolution();
        Configuration.headless = Boolean.parseBoolean(PropertyReader.get(Property.HEADLESS));
        Configuration.timeout = Integer.parseInt(PropertyReader.get(Property.TIMEOUT_MILLS));
        handleUser(name, password);
    }

    private void handleUser(String name, String password) {
        if (name == null) throw new RuntimeException("Parameter 'user' not specified or invalid");
        if (password == null) throw new RuntimeException("Parameter 'password' not specified or invalid");
        user = new User(name, password);
    }

    @AfterMethod
    public void cleanUp() {
        Selenide.closeWebDriver();
    }
}