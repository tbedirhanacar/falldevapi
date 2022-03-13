package get_http_request_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends HerokuappBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Susan" and last name is "Jones"
     */

    @Test
    public void get05(){
        spec.pathParam("first", "booking").queryParams("firstname", "Eric","lastname", "Wilson");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

    }


}
