package tests;

import org.example.core.PropertyReader;
import org.example.ui.webdriver.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    protected String baseURL;

    @BeforeSuite
    public void loadProperties() {
        PropertyReader.loadConfig("application");
        baseURL = PropertyReader.getProperty("baseUrl");
    }

    @BeforeClass
    public void configBrowser() {
        WebDriverManager.configure();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.close();
    }
}
