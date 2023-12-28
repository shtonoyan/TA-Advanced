package org.example.api.services;

import io.restassured.response.Response;
import org.example.api.ApiBase;
import org.example.api.endpoints.Paths;

import java.util.Map;

public class LaunchesApi {
    public static Response getLaunches(String token, String projectName){
        return ApiBase.get(
                Paths.GET_LAUNCHES,
                token,
                Map.of("projectName", projectName)
        );
    }
}
