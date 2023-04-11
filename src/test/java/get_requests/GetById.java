package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetById extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/1
    When
        User send Get request
    Then
        Status code should be 200
    And
        Body should be like:

      {
    "firstname": "Mark",
    "lastname": "Jackson",
    "totalprice": 849,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2020-12-31",
        "checkout": "2021-07-21"
    },
    "additionalneeds": "Breakfast"
}

     */

    @Test
    public void getById(){
    //set the URL
    spec.pathParams("first","booking","second",1);

    //set the expected data

    //Send the request and get the response

    Response response = given(spec).get("{first}/{second}");
    response.prettyPrint();

    //Do assertion
    response.
            then().
            statusCode(200).
            body("firstname",equalTo("Sally"),
                    "lastname",equalTo("Wilson"),
                    "totalprice",equalTo(564), "depositpaid",equalTo(true),
                    "bookingdates.checkin",equalTo("2018-03-14"),
                    "additionalneeds",equalTo("Breakfast"));






    }

}