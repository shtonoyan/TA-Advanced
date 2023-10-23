package tests.testngtest;

import org.example.core.CustomLogger;
import org.example.ui.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestNgTest extends BaseTest{
    @DataProvider
    public Object[][] credentialsProvider(){
        return new Object[][]{
                {"default", "invalid"},
                {"invalid", "1q2w3e"},
                {"invalid", "invalid"}
        };
    }
    @Test(dataProvider = "credentialsProvider")
    public void negativeLoginTest(String username, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        CustomLogger.log("Browser Opened!!!");
        loginPage.completeLogin(username);
        loginPage.completePassword(password);
        loginPage.clickLoginButton();
        loginPage.verifyErrorMessage("An error occurred while connecting to server: You do not have enough permissions. Bad credentials");
    }
}
