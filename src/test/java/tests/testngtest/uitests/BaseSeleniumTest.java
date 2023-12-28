package tests.testngtest.uitests;

import org.example.api.services.AuthApi;
import org.example.core.PropertyReader;
import org.example.ui.webdriver.DriverManager;
import org.testng.annotations.*;

public abstract class BaseSeleniumTest {
    protected static String accessToken;
    @BeforeSuite
    public void propertyLoader() {
        PropertyReader.loadConfig("webRP");
        accessToken = AuthApi.authCall(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
    }

    @BeforeMethod
    public void browserSetup() {
        DriverManager.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverManager.quitDriver();
    }
}
