package tests.testngtest;

import org.example.ui.webdriver.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseUiTest extends BaseTest{
    @BeforeClass
    public void configBrowser() {
        WebDriverManager.configure();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.close();
    }
}
