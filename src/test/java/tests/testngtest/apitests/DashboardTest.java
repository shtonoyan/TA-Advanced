package tests.testngtest.apitests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.api.services.DashboardApi;
import org.example.core.PropertyReader;
import org.testng.annotations.Test;
import tests.testngtest.BaseApiTest;

public class DashboardTest extends BaseApiTest {
    private final String dashboardName = "Test Dashboard";
    private int dashboardId;
    private final String invalidProjectName = "non_existing_project";

    @Test
    public void createDashboard() {
        Response creationResponse = DashboardApi.createDashboard(accessToken, PropertyReader.getProperty("testProject"), dashboardName);
        creationResponse.then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_CREATED);
        dashboardId = creationResponse.jsonPath().getInt("id");
    }

    @Test(dependsOnMethods = "createDashboard")
    public void createDuplicateDashboard() {
        DashboardApi.createDashboard(accessToken, PropertyReader.getProperty("testProject"), dashboardName)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_CONFLICT);
    }

    @Test
    public void createDashboardInvalidName() {
        DashboardApi.createDashboardWithoutName(accessToken, PropertyReader.getProperty("testProject"))
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test(dependsOnMethods = "createDashboard")
    public void editDashboard() {
        DashboardApi.editDashboardName(accessToken, PropertyReader.getProperty("testProject"), dashboardName, dashboardId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void editDashboardWithInvalidId() {
        DashboardApi.editDashboardName(accessToken, PropertyReader.getProperty("testProject"), dashboardName, 1111)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void editDashboardWithInvalidProject() {
        DashboardApi.editDashboardName(accessToken, invalidProjectName, dashboardName, dashboardId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }

    @Test(priority = 1)
    public void deleteDashboard() {
        DashboardApi.deleteDashboard(accessToken, PropertyReader.getProperty("testProject"), dashboardId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(priority = 1)
    public void deleteDeletedDashboard() {
        DashboardApi.deleteDashboard(accessToken, PropertyReader.getProperty("testProject"), dashboardId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test(priority = 1)
    public void deleteDashboardOfInvalidProject() {
        DashboardApi.deleteDashboard(accessToken, invalidProjectName, dashboardId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }
}
