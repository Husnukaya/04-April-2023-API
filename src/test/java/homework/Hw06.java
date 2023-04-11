package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Hw06 extends ReqresBaseUrl {

      /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */



@Test
    public void get06(){

    //set the url
    spec.pathParam("first","unknown");

    //set expected data

    //Send the request and get the response
    Response response= given(spec).get("{first}");
    response.prettyPrint();

    //Do assertion
    //  1)Status code is 200

    response.then().statusCode(200);

    //2)Print all pantone_values
    JsonPath jsonPath =response.jsonPath();
    List<String> pantone_value = jsonPath.getList("data.pantone_value");
    System.out.println("pantone_value = " + pantone_value);

   // 3)Print all ids greater than 3 on the console

    List<Integer> idsGreaterThan3= jsonPath.getList("data.findAll{it.id>3}.id");
    System.out.println("idsGreaterThan3 = " + idsGreaterThan3);

    //Assert that there are 3 ids greater than 3

    Assert.assertEquals(3,idsGreaterThan3.size());

   // 4)Print all names whose ids are less than 3 on the console
    List<String> names =jsonPath.getList("data.findAll{it.id<3}.name");
    System.out.println("names = " + names);


    //Assert that the number of names whose ids are less than 3 is 2
    Assert.assertEquals(2,names.size());











}

}
