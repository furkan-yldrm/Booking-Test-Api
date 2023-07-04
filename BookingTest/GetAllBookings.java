import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookings {
    @Test
    public void GetAllBookingsTest(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/")
                .then()
                .log().all()
                .statusCode(200);
    }
}
