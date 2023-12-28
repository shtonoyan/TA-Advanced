package tests.testngtest.apitests;

import org.apache.http.HttpStatus;
import org.example.api.services.LaunchesApi;
import org.example.core.PropertyReader;
import org.testng.annotations.Test;
import tests.testngtest.BaseApiTest;

public class LaunchesTest extends BaseApiTest {
    @Test
    public void getProjectLaunches(){
        LaunchesApi.getLaunches(accessToken, PropertyReader.getProperty("testProject"))
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getProjectLaunchesNegative(){
        LaunchesApi.getLaunches(accessToken, "invalid_project")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }
}
