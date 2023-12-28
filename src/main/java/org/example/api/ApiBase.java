package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiBase {
    public static Response post(String uri, Object object, RequestSpecification requestSpecification) {
        return RestAssured
                .given(requestSpecification)
                .body(object)
                .post(uri);
    }

    public static Response authPost(String uri, String username, String password) {
        return RestAssured
                .given(RequestSpecifications.getSpecificationForAuthRequest(Map.of("grant_type", "password", "username", username, "password", password)))
                .log()
                .all()
                .post(uri);
    }

    public static Response get(String uri, String token, Map<String, String> pathParams) {
        return RestAssured
                .given(RequestSpecifications.getSpecification(token))
                .pathParams(pathParams)
                .log()
                .all()
                .get(uri);
    }

    public static Response post(String uri, String token, Object object, Map<String, String> pathParams) {
        return RestAssured
                .given(RequestSpecifications.getSpecification(token))
                .pathParams(pathParams)
                .log()
                .all()
                .body(object)
                .post(uri);
    }

    public static Response put(String uri, String token, Object object, Map<String, String> pathParams) {
        return RestAssured
                .given(RequestSpecifications.getSpecification(token))
                .pathParams(pathParams)
                .log()
                .all()
                .body(object)
                .put(uri);
    }

    public static Response delete(String uri, String token, Map<String, String> pathParams) {
        return RestAssured
                .given(RequestSpecifications.getSpecification(token))
                .pathParams(pathParams)
                .log()
                .all()
                .delete(uri);
    }
}
