package tests.junittests;

import org.example.core.PropertyReader;
import org.example.ui.pages.LaunchesPage;
import org.example.ui.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collections;
import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
public class LaunchesSortingTest extends BaseJunitTest {
    private final String username = PropertyReader.getProperty("username");
    private final String password = PropertyReader.getProperty("password");

    @BeforeEach
    public void loginToApp() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.loginToApplication(username, password);
    }

    @Test
    public void sortByTotals() {

        LaunchesPage launchesPage = new LaunchesPage();
        launchesPage.open();

        List<String> initialTotalValues = launchesPage.getTotalValues();
        Collections.sort(initialTotalValues);

        launchesPage.sortByTotal();
        List<String> finalTotalValues = launchesPage.getTotalValues();
        Assertions.assertEquals(initialTotalValues, finalTotalValues);
    }

    @Test
    public void sortByPassed() {
        LaunchesPage launchesPage = new LaunchesPage();
        launchesPage.open();

        List<Integer> initialPassedValues = launchesPage.getPassedValues();
        Collections.sort(initialPassedValues);

        launchesPage.sortByPassed();
        List<Integer> finalPassedValues = launchesPage.getPassedValues();
        Assertions.assertEquals(initialPassedValues, finalPassedValues);
    }

    @Test
    public void sortByFailed() {
        LaunchesPage launchesPage = new LaunchesPage();
        launchesPage.open();

        List<String> initialFailed = launchesPage.getFailedValues();
        Collections.sort(initialFailed);

        launchesPage.sortByFailed();
        List<String> finalFailedValues = launchesPage.getFailedValues();
        Assertions.assertEquals(initialFailed, finalFailedValues);
    }
}
