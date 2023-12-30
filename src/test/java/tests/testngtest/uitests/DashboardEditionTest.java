package tests.testngtest.uitests;

import org.example.api.services.DashboardApi;
import org.example.core.PropertyReader;
import org.example.ui.pages.seleniumpages.DashboardPage;
import org.example.ui.pages.seleniumpages.LoginPage;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class DashboardEditionTest extends BaseSeleniumTest {
    private final String dashboardName = "Test Dashboard";

    @BeforeMethod
    public void login() {
        String project = PropertyReader.getProperty("testProject");
        DashboardApi.createDashboard(accessToken, project, dashboardName);
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.completeLogin(PropertyReader.getProperty("username"));
        loginPage.completePassword(PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void deleteDashboard() {
        String project = PropertyReader.getProperty("testProject");
        int dashboardId = DashboardApi.getDashboardId(accessToken, project, dashboardName);
        DashboardApi.deleteDashboard(accessToken, project, dashboardId);
    }


    @Test
    public void editDashboard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openPage();

        dashboardPage.editDashboardDescription(dashboardName);
        assertTrue(dashboardPage.getDashboardDescription(dashboardName).contains("edited"));
    }

}
