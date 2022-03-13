package get_http_request_method;

import base_urls.RestApiBaseUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Data;
import pojos.Employee;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get11 extends RestApiBaseUrl {

    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
          Status code should be 200
          Use Gson and ObjectMapper
          make sure you have 24 records for data

     */

    @Test
    public void get11() throws IOException {

        //Set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employees");

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        //Validate the status code
        response.then().assertThat().statusCode(200);

        ObjectMapper obj = new ObjectMapper(); //This is a converter from Java to Json, Json to Java

        Employee employee = obj.readValue(response.asString(), Employee.class);

        for (int i = 0; i<employee.getData().size(); i++){
            System.out.println("The person "+(i+1)+" is "+employee.getData().get(i).getEmployee_name());
        }

        assertTrue("The data size does not match",employee.getData().size()==24);

    }

    @Test
    public void get11D(){
        //Set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employees");

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        //Do the assertions and validate
        Gson gson = new Gson();

        Employee employees = gson.fromJson(response.asString(), Employee.class);

        System.out.println("The employee data size: " + employees.getData().size());

        assertTrue("The data size does not match", employees.getData().size()==24);

    }




}
