import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.Order;
import ru.praktikum.OrderClient;
import ru.praktikum.OrderGenerator;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class SuccessOrderCreation {

    private Order order;
    OrderClient orderClient;
    int track_id;
    private final List<String> scooterColors;

    public SuccessOrderCreation(String scooterColors) {
        this.scooterColors = List.of(scooterColors);
    }

    @Parameterized.Parameters( name = "{index}: Color ({0})" )
    public static Object[][] getColors() {
        return new Object[][]{
                {"\"BLACK\", \"GREY\""},
                {"\"GREY\""},
                {"\"BLACK\""},
                {""},
        };
    }

    @Before
    public void setUp() {
        orderClient = new OrderClient();
        order = new Order(scooterColors);
    }

    @After
    public void tearDown() {
        orderClient.cancel(track_id);
    }

    @DisplayName("Check status code of /api/v1/orders - success Creating Order Test with different color")
    @Test
    public void successCreatingOrderTest() throws JsonProcessingException {
        Order order = OrderGenerator.getRandomOrder();
        ValidatableResponse createResponse = orderClient.create(order);
        var track_id = createResponse.statusCode(201).extract().body();
        assertThat("Order cannot created", track_id, is(notNullValue()));
    }
}



