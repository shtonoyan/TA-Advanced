package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.core.CustomLogger;
import org.example.ui.pages.LoginPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Login to RP application")
    public void myFirstTest() {
        Selenide.open("http://localhost:8080/ui/#login");
        CustomLogger.log("Browser Opened!!!");
        LoginPage loginPage = new LoginPage();
        loginPage.completeLogin("default");
        loginPage.completePassword("1q2w3e");
        loginPage.clickLoginButton();
    }
}
