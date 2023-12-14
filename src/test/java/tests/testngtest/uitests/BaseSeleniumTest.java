package tests.testngtest.uitests;

import org.example.core.PropertyReader;
import org.example.ui.webdriver.DriverManager;
import org.testng.annotations.*;

public abstract class BaseSeleniumTest {
    @BeforeSuite
    public void propertyLoader() {
        PropertyReader.loadConfig("webRP");
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
