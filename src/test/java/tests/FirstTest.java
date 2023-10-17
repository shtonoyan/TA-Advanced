package tests;

import com.codeborne.selenide.Selenide;
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
        Selenide.open(baseURL + "/ui/#login");
        CustomLogger.log("Browser Opened!!!");
        LoginPage loginPage = new LoginPage();
        loginPage.completeLogin(PropertyReader.getProperty("username"));
        loginPage.completePassword("password");
        loginPage.clickLoginButton();
    }
}
