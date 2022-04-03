package ru.praktikum;
import static io.restassured.RestAssured.*;
import static ru.praktikum.CourierGenerator.getRandomLoginPasswordWithoutFirstName;
import static ru.praktikum.CourierGenerator.getRandomLoginPasswordWithoutFirstNameAndPassword;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class CourierClient extends ScooterRestClient {

    private static final String COURIER_PATH = "/api/v1/courier";

@Step("Login with credentials")
    public ValidatableResponse login(CourierCredentials credentials) {
        return given()
                .spec(getBaseSpec())
                .body(credentials)
                .when()
                .post(COURIER_PATH + "/login")
                .then();
    }

@Step("Login with inCorrect credentials")
    public ValidatableResponse loginInCorrect() {

    Courier courier = new Courier("ninja", "1234");

    return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(COURIER_PATH + "/login")
                .then();
    }

@Step("Login with login only")
    public ValidatableResponse loginWithLoginOnly(Courier courier) {

    courier = getRandomLoginPasswordWithoutFirstNameAndPassword();

        return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(COURIER_PATH + "/login")
                .then();
    }

@Step("Create a courier with login, password, firstName")
    public ValidatableResponse create(Courier courier) throws JsonProcessingException {

    String result = new ObjectMapper().writeValueAsString(courier);

        return given()
                .spec(getBaseSpec())
                .header("Content-type", "application/json")
                .and()
                .body(result)
                .when()
                .post(COURIER_PATH)
                .then();

    }

@Step("Create a courier without firstName")
    public ValidatableResponse createWithoutFirstName(Courier courier)  {

    courier = getRandomLoginPasswordWithoutFirstName();

        return given()
                .spec(getBaseSpec())
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then();

    }

@Step("Delete a courier by courierId {courierId}")
    public ValidatableResponse delete(int courierId) {

        return given()
                .spec(getBaseSpec())
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete(COURIER_PATH + "/:id" + courierId)
                .then();
    }
}


