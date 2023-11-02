package tests.testngtest;

import org.example.core.PropertyReader;
import org.example.ui.webdriver.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    @BeforeSuite
    public void loadProperties() {
        PropertyReader.loadConfig("localhostRP");
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
