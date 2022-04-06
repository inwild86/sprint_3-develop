import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.Courier;
import ru.praktikum.CourierClient;
import ru.praktikum.CourierCredentials;
import ru.praktikum.CourierGenerator;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import io.qameta.allure.junit4.DisplayName;

public class CourierLoginTest {

    CourierClient courierClient;
    Courier courier;
    int courierId;

    @Before
    public void setUp() throws JsonProcessingException {
        courierClient = new CourierClient();
        courier = CourierGenerator.getRandomLoginPasswordFirstName();
        courierClient.create(courier);
    }

    @After
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @DisplayName("Check status code of /api/v1/courier/login - success Login Courier With Login And Password")
    //для авторизации нужно передать все обязательные поля;
    @Test
    public void successLoginCourierWithLoginAndPasswordTest() {
        var cred = new CourierCredentials(courier.login, courier.password);
        ValidatableResponse loginResponse = courierClient.login(cred);
        int courierId = loginResponse.statusCode(200).extract().path("id");
        assertThat("Courier not created", courierId, is(notNullValue()));
    }
    //если какого-то поля нет, запрос возвращает ошибку;
    @DisplayName("Check status code of /api/v1/courier/login - unSuccess Login Courier With Login Only")
    @Test
    public void unSuccessLoginCourierWithLoginOnlyTest() {
        var cred = new CourierCredentials(courier.login);
        ValidatableResponse loginResponse = courierClient.login(cred);
        var statusCode = loginResponse.extract().statusCode();
        assertThat("Courier can be login without password", statusCode, equalTo(SC_BAD_REQUEST));
    }
//если авторизоваться под несуществующим пользователем, запрос возвращает ошибку;
    @DisplayName("Check status code of /api/v1/courier/login - unSuccess Login Courier With Incorrect Login And Password")
    @Test
    public void unSuccessLoginCourierWithIncorrectLoginAndPasswordTest() {
        ValidatableResponse loginResponse = courierClient.loginInCorrect();
        var statusCode = loginResponse.extract().statusCode();
        assertThat("Courier can be crate without FirstName", statusCode, equalTo(SC_NOT_FOUND));
    }
}


