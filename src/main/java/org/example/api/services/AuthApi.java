package org.example.api.services;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.api.ApiBase;
import org.example.api.endpoints.Paths;

public class AuthApi {
    public static String authCall(String username, String password) {
        Response responce = ApiBase.authPost(Paths.GET_AUTH_TOKEN,
                username,
                password);
        responce
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
        return responce.jsonPath()
                .getString("access_token");
    }
}
