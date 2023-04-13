package homework;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PetStorePojo;

import static io.restassured.RestAssured.given;

public class Hw08 extends PetStoreBaseUrl {

     /*
    Type automation code to create a 'user' by using "https://petstore.swagger.io/"" documantation.
    */
     /*
        Given
            1) https://petstore.swagger.io/v2/user
            2) {
                  "username": "JohnDoe",
                  "firstName": "John",
                  "lastName": "Doe",
                  "email": "john@doe.com",
                  "password": "1234",
                  "phone": "1234",
                  "userStatus": 123
                }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "code": 200,
                                                "type": "unknown",
                                                "message": "6874988058"
                                             }
     */

    @Test
    public void post08(){  //Set the url
//        spec.pathParam("first","users");
//
//        //Set the expected data
//        PetStorePojo expectedData= new PetStorePojo("JohnDoe","John","Doe","john@doe.com","1234","1234",123);
//        System.out.println("expectedData = " + expectedData);
//
//        //Send the request and get the response
//        Response response = given(spec).body(expectedData).post("{first}");
//       //response.prettyPrint();
//       PetStorePojo actualData = response.as(PetStorePojo.class);
//        System.out.println("actualData = " + actualData);
//


    }



}
