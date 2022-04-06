import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.Courier;
import ru.praktikum.CourierClient;
import ru.praktikum.CourierGenerator;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import io.qameta.allure.junit4.DisplayName;

public class CreatingCourierTest {
    CourierClient courierClient;
    Courier courier;
    int courierId;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = CourierGenerator.getRandomLoginPasswordFirstName();
    }

    @After
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @DisplayName("Check status code of /api/v1/courier - unSuccess Creating Courier (Login is existing)")
    @Test
    public void unSuccessCreatingCourierWithExistingLoginTest() throws JsonProcessingException {
        Courier courier = new Courier("null", "null", "null");
        ValidatableResponse createResponse = courierClient.create(courier);
        var response = createResponse.statusCode(409).extract().body();
        assertThat("Courier created with existing login", response, is(notNullValue()));
    }

    @DisplayName("Check status code of /api/v1/courier - unSuccess Creating Courier ( FirstName none)")
    @Test
    public void unSuccessCreatingCourierWithoutFirstNameTest() throws JsonProcessingException {
        var cour = CourierGenerator.getRandomLoginPasswordWithoutFirstName();
        ValidatableResponse createResponse = courierClient.create(courier);
        var statusCode = createResponse.extract().statusCode();
        assertThat("Courier login without password", statusCode, equalTo(SC_BAD_REQUEST));
    }

    @DisplayName("Check status code of /api/v1/courier - success Creating Courier")
    @Test
    public void successCreatingCourierTest() throws JsonProcessingException {
        var cour = CourierGenerator.getRandomLoginPasswordFirstName();
        ValidatableResponse createResponse = courierClient.create(cour);
        var response = createResponse.statusCode(201).extract().body();
        assertThat("Courier not created", response, is(notNullValue()));
    }
}

