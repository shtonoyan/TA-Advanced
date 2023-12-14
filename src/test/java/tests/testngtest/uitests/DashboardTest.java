package tests.testngtest.uitests;

import org.example.core.PropertyReader;
import org.example.ui.pages.seleniumpages.DashboardPage;
import org.example.ui.pages.seleniumpages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DashboardTest extends BaseSeleniumTest {
    private final String dashboardName = "Test Dashboard";
    private final String dashboardDescription = "Random Description";

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.completeLogin(PropertyReader.getProperty("username"));
        loginPage.completePassword(PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();
    }

    @Test
    public void addNewDashboard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openPage();

        dashboardPage.clickAddNewDashboardButton();
        dashboardPage.enterDashboardName(dashboardName);
        dashboardPage.enterDashboardDescription(dashboardDescription);
        dashboardPage.createDashboard();

        dashboardPage.openPage();
        assertTrue(dashboardPage.dashboardNames().contains(dashboardName));
    }

    @Test(dependsOnMethods = "addNewDashboard")
    public void editDashboard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openPage();

        dashboardPage.editDashboardDescription(dashboardName);
        assertTrue(dashboardPage.getDashboardDescription(dashboardName).contains("edited"));
    }


    @Test(dependsOnMethods = {"editDashboard"})
    public void deleteDashboard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openPage();

        dashboardPage.deleteDashboard(dashboardName);
        assertFalse(dashboardPage.dashboardNames().contains(dashboardName));
    }
}
