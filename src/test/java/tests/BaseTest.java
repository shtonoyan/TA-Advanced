package tests;

import org.example.ui.webdriver.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    @BeforeClass
    public void configBrowser(){
        WebDriverManager.configure();
    }
    @AfterClass
    public void tearDown(){
        WebDriverManager.close();
    }
}
