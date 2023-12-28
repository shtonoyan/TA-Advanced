package org.example.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.core.PropertyReader;

import java.util.Map;

public class RequestSpecifications {
    public static final String BASE_URL = PropertyReader.getProperty("baseUrl");

    public static RequestSpecification getSpecificationForAuthRequest(Map<String, String> formParams){
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType(ContentType.URLENC.withCharset("utf-8"))
                .header("Authorization", "Basic dWk6dWltYW4=")
                .formParams(formParams);
    }

    public static RequestSpecification getSpecification(String token){
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token);
    }
}
