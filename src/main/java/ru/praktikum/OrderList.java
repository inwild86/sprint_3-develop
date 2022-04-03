package ru.praktikum;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class OrderList extends ScooterRestClient{
    private static final String ORDERLIST_PATH = "/v1/orders";

    public static Integer courierId;
    public static String nearestStation;
    public static String limit;
    public static String page;

    public OrderList(Integer courierId, String nearestStation, String limit, String page) {
        this.courierId = courierId;
        this.nearestStation = nearestStation;
        this.limit = limit;
        this.page = page;
    }

    public static Integer getCourierId() {
        return courierId;
    }

    public static String getNearestStation() {
        return nearestStation;
    }

    public static String getLimit() {
        return limit;
    }

    public static String getPage() {
        return page;
    }

    public static void setCourierId(Integer courierId) {
        OrderList.courierId = courierId;
    }

    public static void setNearestStation(String nearestStation) {
        OrderList.nearestStation = nearestStation;
    }

    public static void setLimit(String limit) {
        OrderList.limit = limit;
    }

    public static void setPage(String page) {
        OrderList.page = page;
    }

    @Step("Get list of orders by courierId")
    public static ValidatableResponse getOrdersList() {
        return   given()
                .spec(getBaseSpec())
                .header("Content-type", "application/json")
                .queryParam("courierId", 1)
                .and()
                .when()
                .get(ORDERLIST_PATH)
                .then().statusCode(200);
    }


}
