import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class GetBookingByID {
    @Test
    public void GetBookingByIDTest(){


        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/57");

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        String firstname = response.jsonPath().getJsonObject("firstname");
        String lastname = response.jsonPath().getJsonObject("lastname");

        int totalPrice = response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("Lewis",firstname);
        Assertions.assertEquals("Saunders",lastname);
    }
}
