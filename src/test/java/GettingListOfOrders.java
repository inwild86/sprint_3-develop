import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.praktikum.*;
import io.qameta.allure.junit4.DisplayName;

public class GettingListOfOrders {

    @DisplayName("Check status code of /api/v1/orders/track - Getting List Of Orders By CourierId")
    @Test
    public void GettingListOfOrdersByCourierId() {
        ValidatableResponse listOfOrdersByCourierId = OrderList.getOrdersList();
        listOfOrdersByCourierId.statusCode(200);
    }

}

