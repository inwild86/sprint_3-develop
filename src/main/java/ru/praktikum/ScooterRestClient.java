package ru.praktikum;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class ScooterRestClient {

    public static final String BASE_URL = "http://qa-scooter.praktikum-services.ru/";

    protected static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON) // тип данных в body
                .setBaseUri(BASE_URL)
                .build();

    }

}
