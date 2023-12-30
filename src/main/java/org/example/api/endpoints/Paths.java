package org.example.api.endpoints;

public interface Paths {
    String GET_AUTH_TOKEN = "/uat/sso/oauth/token";
    String GET_LAUNCHES = "/api/v1/{projectName}/launch";
    String GET_DASHBOARDS = "/api/v1/{projectName}/dashboard";
    String DASHBOARD_CREATE = "/api/v1/{projectName}/dashboard";
    String DASHBOARD_EDIT = "/api/v1/{projectName}/dashboard/{dashboardId}";
    String DASHBOARD_DELETE = "/api/v1/{projectName}/dashboard/{dashboardId}";
}
