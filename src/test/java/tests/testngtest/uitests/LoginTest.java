package tests.testngtest.uitests;

import lombok.SneakyThrows;
import org.example.core.PropertyReader;
import org.example.ui.pages.seleniumpages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseSeleniumTest {
    @SneakyThrows
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();

        loginPage.completeLogin(PropertyReader.getProperty("username"));
        loginPage.completePassword(PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
