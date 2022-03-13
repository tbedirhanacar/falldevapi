package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends JsonPlaceHolderBaseUrl {

    /*
       When
           I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
           with the request body {
                                   "userId": 55,
                                   "title": "Tidy your room",
                                   "completed": false
                                  }
       Then
           Status code is 201
           And response body is like {
                                       "userId": 55,
                                       "title": "Tidy your room",
                                       "completed": false,
                                       "id": 201
                                     }
    */
    @Test
    public void get02(){

        spec.pathParam("First", "todos");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed", false);

        //Create data using pojo
        Todo todo = new Todo(55, 201, "Tidy your room", false);

        Response response = given().spec(spec).contentType(ContentType.JSON).when().body(todo).post("/{First}");

        response.then().assertThat().statusCode(201);
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals("The data does not match!", expectedData.get("userId"), actualData.get("userId"));
        assertEquals("The data does not match!", expectedData.get("completed"), actualData.get("completed"));
        assertEquals("The data does not match!", 201, actualData.get("id"));
        assertEquals("The data does not match!", expectedData.get("title"), actualData.get("title"));

    }
}
