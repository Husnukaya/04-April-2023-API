package gmibank_api;

import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.Customer;
import pojos.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetCustomer extends GmiBankBaseUrl {
         /*
        Given
          https://www.gmibank.com/api/tp-customers/110452
        When
         I send GET Request to the URL
      Then
         Status code is 200
         And response body is like {
                                        "id": 110452,
                                        "firstName": "Jasmine",
                                        "lastName": "Stehr",
                                        "middleInitial": "V",
                                        "email": "marni.zboncak@yahoo.com",
                                        "mobilePhoneNumber": "463-609-2097",
                                        "phoneNumber": "1-112-497-0270",
                                        "zipCode": "16525",
                                        "address": "14387 Al Ridge5343 Bert Burgs",
                                        "city": "Waltermouth",
                                        "ssn": "761-59-2911",
                                        "createDate": "2021-11-28T21:00:00Z",
                                        "zelleEnrolled": false,
                                        "country": {
                                            "id": 3,
                                            "name": "USA",
                                            "states": null
                                        },
                                        "state": "California",
                                        "user": {
                                            "id": 110016,
                                            "login": "leopoldo.reinger",
                                            "firstName": "Jasmine",
                                            "lastName": "Stehr",
                                            "email": "marni.zboncak@yahoo.com",
                                            "activated": true,
                                            "langKey": "en",
                                            "imageUrl": null,
                                            "resetDate": null
                                        },
                                        "accounts": []
                                    }
      */

    @Test
    public void getCustomerById(){
        //Set the url
        spec.pathParams("first","api","second","tp-customers","third",110452);

        //Set the expected data
        Country country = new Country(3,"USA",null);
        User user = new User(110016,"leopoldo.reinger","Jasmine","Stehr","marni.zboncak@yahoo.com",true,"en",null,null);
        ArrayList<Object> accountList = new ArrayList<>();
        Customer expectedData = new Customer(110452,"Jasmine","Stehr","V","marni.zboncak@yahoo.com","463-609-2097", "1-112-497-0270","16525","14387 Al Ridge5343 Bert Burgs","Waltermouth","761-59-2911","2021-11-28T21:00:00Z",false,country,"California",user,accountList);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).headers("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjgxNDgxMTM3fQ.lAaZqZmGBU8S_7jspST9Mr6ChklZxfLS7ucpTXlE4Y3CTFrFUPuD8dLsZ8XP5aA100oKhTpbfrDSNdkN0Km_dQ").get("{first}/{second}/{third}");
        response.prettyPrint();






    }
}