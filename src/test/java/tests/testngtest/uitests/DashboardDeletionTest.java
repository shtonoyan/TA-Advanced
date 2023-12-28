package tests.testngtest.uitests;

import org.example.api.services.DashboardApi;
import org.example.core.PropertyReader;
import org.example.ui.pages.seleniumpages.DashboardPage;
import org.example.ui.pages.seleniumpages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class DashboardDeletionTest extends BaseSeleniumTest {
    private final String dashboardName = "Test Dashboard";

    @BeforeMethod
    public void dataPreparation() {
        String project = PropertyReader.getProperty("testProject");
        DashboardApi.createDashboard(accessToken, project, dashboardName);
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.completeLogin(PropertyReader.getProperty("username"));
        loginPage.completePassword(PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();
    }

    @Test
    public void deleteDashboard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openPage();

        dashboardPage.deleteDashboard(dashboardName);
        assertFalse(dashboardPage.dashboardNames().contains(dashboardName));
    }
}
