package org.example.api.requestbodies;


import org.example.api.models.CreateDashboard;

public class DashboardRequests {
    public static CreateDashboard getBodyForDashboardCreation(String name) {
        return CreateDashboard.builder()
                .name(name)
                .description("Random description")
                .build();
    }

    public static CreateDashboard getBodyForDashboardCreation() {
        return CreateDashboard.builder()
                .description("Random description")
                .build();
    }

    public static CreateDashboard getBodyForDashboardNameEdit(String dashboardName){
        return CreateDashboard.builder()
                .name(dashboardName+" Updated")
                .build();
    }
}
