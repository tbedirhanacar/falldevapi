package get_http_request_method;

import base_urls.RestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get10 extends RestApiBaseUrl {

    /*
        When
            I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Make sure Rhona Davidson earns more than Herrod Chandler
               {
               "id": 7,
               "employee_name": "Herrod Chandler".
               "employee salary": 137500,
               "employee_age": 59,
               "profile_image": ""
               }
               {
               "id": 8,
               "employee_name": "Rhona Davidson",
               "employee salary": 327900,
               "employee_age": 55,
               "profile_image": ""
               }

     */

    @Test
    public void get10(){
        //Set the url
        spec.pathParams("first", "api","second", "v1","third", "employee","final",7);

        //Send a get request
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        JsonPath json1 = response.jsonPath();

        int salaryOfHarrod = json1.getInt("data.employee_salary");
        System.out.println(salaryOfHarrod);

        //Do the assertion for status code and content type
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        //Set the url
        spec.pathParams("first", "api","second", "v1","third", "employee","final",8);

        //Send a get request
        Response response2 = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

        JsonPath json2 = response2.jsonPath();

        int salaryOfRhona = json2.getInt("data.employee_salary");
        System.out.println(salaryOfRhona);

    }




}
