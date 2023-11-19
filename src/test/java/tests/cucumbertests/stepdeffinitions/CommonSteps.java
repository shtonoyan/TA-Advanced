package tests.cucumbertests.stepdeffinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.example.core.PropertyReader;
import org.example.ui.pages.LoginPage;
import org.example.ui.webdriver.WebDriverManager;

public class CommonSteps {
    LoginPage loginPage = new LoginPage();
    @BeforeAll
    public static void configureWebDriver(){
        PropertyReader.loadConfig("webRP");
        WebDriverManager.configure();
    }

    @Before
    public void openLoginPage(){
        loginPage.open();
    }

    @After
    public void tearDown(){
        WebDriverManager.close();
    }

    @Given("Login to the Report Portal")
    public void login(){
        loginPage.loginToApplication(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
    }
}
