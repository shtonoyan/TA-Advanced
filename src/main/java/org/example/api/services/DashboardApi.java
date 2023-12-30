package org.example.api.services;

import io.restassured.response.Response;
import org.example.api.ApiBase;
import org.example.api.endpoints.Paths;
import org.example.api.requestbodies.DashboardRequests;

import java.util.Map;

public class DashboardApi {
    public static Response getDashboards(String token, String projectName){
        return ApiBase.get(
                Paths.GET_DASHBOARDS,
                token,
                Map.of("projectName", projectName)
        );
    }

    public static int getDashboardId(String token, String projectName, String dashboardName){
        Response getDashboards = getDashboards(token, projectName);
        return getDashboards.jsonPath().getInt("content.find{it.name == '"+dashboardName+"'}.id");
    }
    public static Response createDashboard(String token, String projectName, String name) {
        return ApiBase.post(
                Paths.DASHBOARD_CREATE,
                token,
                DashboardRequests.getBodyForDashboardCreation(name),
                Map.of("projectName", projectName)
        );
    }

    public static Response createDashboardWithoutName(String token, String projectName) {
        return ApiBase.post(
                Paths.DASHBOARD_CREATE,
                token,
                DashboardRequests.getBodyForDashboardCreation(),
                Map.of("projectName", projectName)
        );
    }

    public static Response editDashboardName(String token, String projectName, String dashboardName, int dashboardId){
        return ApiBase.put(
                Paths.DASHBOARD_EDIT,
                token,
                DashboardRequests.getBodyForDashboardNameEdit(dashboardName),
                Map.of("projectName", projectName, "dashboardId", String.valueOf(dashboardId))
        );
    }

    public static Response deleteDashboard(String token, String projectName, int dashboardId){
        return ApiBase.delete(
                Paths.DASHBOARD_DELETE,
                token,
                Map.of("projectName", projectName, "dashboardId", String.valueOf(dashboardId))
        );
    }
}
