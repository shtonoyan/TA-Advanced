package tests.junittests;

import org.example.core.PropertyReader;
import org.example.ui.webdriver.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.AfterClass;

public abstract class BaseJunitTest {
    @BeforeAll
    public static void loadProperties() {
        PropertyReader.loadConfig("localhostRP");
    }

    @BeforeAll
    public static void configBrowser() {
        WebDriverManager.configure();
    }

    @AfterAll
    public static void tearDown() {
        WebDriverManager.close();
    }
}
