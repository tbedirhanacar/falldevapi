package get_http_request_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get09 extends HerokuappBaseUrl {

    /*
        When
            I send GET Request to https://restful-booker.herokuapp.com/booking/1
        Then
            Response body should be like that;
            {
                "firstname": "Eric",
                "lastname": "Jones",
                "totalprice": 355,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2020-11-09",
                    "checkout": "2017-04-30"
                }
            }
     */

    @Test
    public void get09(){
        spec.pathParams("first", "booking", "second", 1);

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("firstname", "Eric");
        expectedMap.put("lastname", "Ericsson");
        expectedMap.put("totalprice", 615);
        expectedMap.put("depositpaid", false);
        Map<String, Object> expectedDates = new HashMap<>();
        expectedDates.put("checkin", "2015-02-10");
        expectedDates.put("checkout", "2019-07-30");
        expectedMap.put("bookingdates", expectedDates);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualMap = response.as(HashMap.class);
        System.out.println(actualMap);
        assertEquals("The data does not match", expectedMap.get("firstname"), actualMap.get("firstname"));
        assertEquals("The data does not match", expectedMap.get("lastname"), actualMap.get("lastname"));
        assertEquals("The data does not match", expectedMap.get("totalprice"), actualMap.get("totalprice"));
        assertEquals("The data does not match", expectedMap.get("depositpaid"), actualMap.get("depositpaid"));
        assertEquals("The data does not match", expectedMap.get("bookingdates"), actualMap.get("bookingdates"));

    }






}


