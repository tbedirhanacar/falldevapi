package get_http_request_method;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/3
    When
        user sends a request to the url
    Then
        HTTP Status code should be 200
    And
        ContentType should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    */

    @Test
    public void get01(){
        //Set the url
        String url = "https://restful-booker.herokuapp.com/booking/3";
        //This is the primitive way and not recommended

        //Set the expected data

        //Type the automation script to send the request

        Response response = given().when().get(url);
        response.prettyPrint();

        //Do the assertions
        response.then().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
    }


}
