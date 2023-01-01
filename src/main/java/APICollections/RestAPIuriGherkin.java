package APICollections;//import java.util.*;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class RestAPIuriGherkin {

    RequestSpecification httpRequestSpecification;
    public void setupRequestSpecification() {
        //Specify base URI
        RestAssured.baseURI = "https://reqres.in/api/";
        //request specification
         httpRequestSpecification = RestAssured.given();

        //capturing http request in response

        //commented below as we are posting
        //response = httpRequestSpecification.request(Method.POST,BASEPATH);
        /*httpRequestSpecification.baseUri(URI+"/").basePath(BASEPATH);*/


    }
    @Test
    public void test1() {
        given(httpRequestSpecification).
                get("users?page=2").
                then().
                statusCode(200).
                body("data[0].email", equalTo("michael.lawson@reqres.in"));
        //equalTo method is part of static org.hamcrest.Matchers.* package
    }

    @Test(enabled = false)
    public void test2() {
        baseURI = "https://reqres.in/api/";

        given()
                .basePath("users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(7));
        //equalTo method is part of static org.hamcrest.Matchers.* package
    }
}
