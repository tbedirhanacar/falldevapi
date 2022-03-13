package get_http_request_method;

import base_urls.RestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get07 extends RestApiBaseUrl {

    /*
       Given
            http://dummy.restapiexample.com/api/v1/employee/7
       When
            I send a GET request to the Url
       Then
            HTTP Status Code should be 200
       And
            Response format should be "application/json"
       And
            Herrod Chandler should be the employee name
       And
             "employee_salary":137500 should be expected salary
       And
           "id":7 should be expected id

     */

    @Test
    public void get07(){
        spec.pathParams("first","api","second","v1","third","employee","fourth",7);

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");
        response.prettyPrint();

        //1st way of validation
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("data.employee_name", equalTo("Herrod Chandler"),
                        "data.employee_salary", equalTo(137500),
                        "data.id",equalTo(7));

        //2.way of validation
        JsonPath json = response.jsonPath();
//        System.out.println(json.getString("data.employee_name").equals("Herrod Chandler"));
//        System.out.println(json.getString("data.employee_salary").equals("137500"));
//
//        System.out.println(json.getInt("data.employee_salary") == 137500);

        //Soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("data.employee_name"),"Herrod Chandler","The data does not match");
        softAssert.assertEquals(json.getInt("data.employee_salary"),137500, "The data does not match");

        softAssert.assertAll();


    }


}
