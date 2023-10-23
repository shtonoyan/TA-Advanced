package tests.testngtest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.core.CustomLogger;
import org.example.core.PropertyReader;
import org.example.ui.pages.LoginPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Login to RP application")
    public void myFirstTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        CustomLogger.log("Browser Opened!!!");
        loginPage.completeLogin(PropertyReader.getProperty("username"));
        loginPage.completePassword(PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();
    }
}
