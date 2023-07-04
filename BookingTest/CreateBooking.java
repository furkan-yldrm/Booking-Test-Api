import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBooking {

    @Test
    public void CreateBookingTest(){

        JSONObject body = new JSONObject();
        body.put("firstname","Furkan");
        body.put("lastname","Yıldırım");
        body.put("totalprice","500");
        body.put("depositpaid",true);

        JSONObject bookingDate = new JSONObject();
        bookingDate.put("checkin","2023-06-25");
        bookingDate.put("checkout","2023-06-28");

        body.put("bookingdates", bookingDate);
        body.put("additionalneeds","Lahmacun");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking");

        response
                .then()
                .statusCode(200);

        response.prettyPrint();
    }
}
