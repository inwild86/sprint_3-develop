import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.Order;
import ru.praktikum.OrderClient;
import ru.praktikum.OrderGenerator;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import io.qameta.allure.junit4.DisplayName;


public class SuccessOrderCreation {
    OrderClient orderClient;
    int track_id;

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @After
    public void tearDown(){
        orderClient.cancel(track_id);
    }

    @DisplayName("Check status code of /api/v1/orders - success Creating Order Test with one color")
    @Test
    public void successCreatingOrderTest() throws JsonProcessingException {
        var list = new ArrayList<String>();
        list.add("GREY");
        Order order = OrderGenerator.getRandomOrder();
        ValidatableResponse createResponse = orderClient.create(order);
        var track_id = createResponse.statusCode(201).extract().body();
        assertThat("Order cannot created", track_id, is(notNullValue()));

    }

    @DisplayName("Check status code of /api/v1/orders - success Creating Order Test with none color")
    @Test
    public void successCreatingOrderTestWhitoutColor() throws JsonProcessingException {
        var list = new ArrayList<String>();
        list.add(" ");
        Order order = OrderGenerator.getRandomOrder();
        ValidatableResponse createResponse = orderClient.create(order);
        var track_id = createResponse.statusCode(201).extract().body();
        assertThat("Order cannot created", track_id, is(notNullValue()));

    }
    
    @DisplayName("Check status code of /api/v1/orders - success Creating Order Test with two color")
    @Test
    public void successCreatingOrderTestWhitTwoColor() throws JsonProcessingException {
        var list = new ArrayList<String>();
        list.add("BLACK, GREY");
        Order order = OrderGenerator.getRandomOrder();
        ValidatableResponse createResponse = orderClient.create(order);
        var track_id = createResponse.statusCode(201).extract().body();
        assertThat("Order cannot created", track_id, is(notNullValue()));

    }
}
