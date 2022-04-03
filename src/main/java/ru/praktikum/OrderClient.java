package ru.praktikum;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class OrderClient extends ScooterRestClient{
    private static final String ORDER_PATH = "/api/v1/orders";

    @Step("Create an order")
    public ValidatableResponse create(Order order) throws JsonProcessingException {

        String result = new ObjectMapper().writeValueAsString(order);

        return given()
                .spec(getBaseSpec())
                .header("Content-type", "application/json")
                .and()
                .body(result)
                .when()
                .post(ORDER_PATH)
                .then();
    }

    @Step("Cancel an order by track_id")
    public ValidatableResponse cancel(int track_id) {
        return given()
                .spec(getBaseSpec())
                .header("Content-type", "application/json")
                .and()
                .when()
                .put(ORDER_PATH + "/cancel" + track_id)
                .then();
    }

}
