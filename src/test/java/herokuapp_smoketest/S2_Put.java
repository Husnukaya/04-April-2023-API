package herokuapp_smoketest;


import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;


public class S2_Put extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    And
        {
            "firstname" : "Mark",
            "lastname" : "Twain",
            "totalprice" : 555,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-01",
                "checkout" : "2024-01-01"
            },
            "additionalneeds" : "Extra Pillow"
        }
    When
        Send put request
    Then
        Staus code shour be 200
    And
        Body should be :
           {
            "firstname": "Mark",
            "lastname": "Twain",
            "totalprice": 555,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2023-01-01",
                "checkout": "2024-01-01"
            },
            "additionalneeds": "Extra Pillow"
        }

     */

 @Test
 public  void putTest(){

 //Set the url
 spec.pathParams("first","booking","second",bookingId);

 //Set the expected data
  BookingDatesPojo bookingDatesPojo= new BookingDatesPojo("2023-01-01","2024-01-01");
  BookingPojo expectedData = new BookingPojo("Mark","Twain",555,false,bookingDatesPojo,"Extra Pillow");
  System.out.println("expectedData = " + expectedData);

  //Send the request and get the response
  Response response= given(spec).headers("Cookie","27ea354a4fe6229").body(expectedData).put("{first}/{second}");
 response.prettyPrint();


 }




}