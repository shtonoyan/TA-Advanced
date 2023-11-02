package tests.junittests;

import org.example.core.CustomLogger;
import org.example.ui.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginJunitTest extends BaseJunitTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void openLoginPage() {
        loginPage.open();
        CustomLogger.log("Browser Opened!!!");
    }

    @ParameterizedTest
    @CsvSource({"invalid, 1q2w3e", "default, invalid", "invalid, invalid"})
    public void negativeLoginTest(String username, String password) {
        loginPage.completeLogin(username);
        loginPage.completePassword(password);
        loginPage.clickLoginButton();

        loginPage.verifyErrorMessage("An error occurred while connecting to server: You do not have enough permissions. Bad credentials");

    }
}
