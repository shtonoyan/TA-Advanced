package tests.junittests;

import org.example.core.CustomLogger;
import org.example.core.PropertyReader;
import org.example.core.Filters;
import org.example.ui.pages.LaunchesPage;
import org.example.ui.pages.LoginPage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class FiltersPresenceTest extends BaseJunitTest {
    private static LoginPage loginPage;

    @BeforeAll
    public static void openLoginPage() {
        loginPage = new LoginPage();
        loginPage.open();
        CustomLogger.log("Browser Opened!!!");
        loginPage.completeLogin(PropertyReader.getProperty("username"));
        loginPage.completePassword(PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();

    }

    @ParameterizedTest
    @Execution(ExecutionMode.CONCURRENT)
    @EnumSource(Filters.class)
    public void filterPresenceTest(Filters filter) {
        LaunchesPage launchesPage = new LaunchesPage();
        launchesPage.open();

        launchesPage.isFilterDisplayed(Filters.getStringValue(filter));
    }

}
