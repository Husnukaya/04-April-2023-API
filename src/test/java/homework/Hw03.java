package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Hw03 extends ReqresBaseUrl {
     /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void get03(){
    //set the url
     spec.pathParams("first","users","second",2);

     //set the expected data
    // Send the request and get the response
        Response response =given(spec).get("{first}/{second}");
        response.prettyPrint();
     //Do assertion
        response.
                then().
                statusCode(200).
                body("data.email",equalTo("janet.weaver@reqres.in"),
                        "data.first_name",equalTo("Janet"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"),
                        "data.last_name",equalTo("Weaver"));




    }

}
