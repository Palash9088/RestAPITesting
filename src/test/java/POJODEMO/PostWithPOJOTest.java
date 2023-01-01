package POJODEMO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostWithPOJOTest {
    @Test
    public void postData()
    {

        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.contentType(ContentType.JSON);

        demoPOJO demoPOJO = new demoPOJO("Shashank","Software Engineer");


        requestSpecification.body(demoPOJO);

        Response response = requestSpecification.request(Method.POST);

        System.out.println("Response Body \n" + response.body().prettyPrint());

        JsonPath jsonPathe = response.jsonPath();


        String name = jsonPathe.get("name");
        String job = jsonPathe.get("job");

        //System.out.println("Name is -> " + name + "\n" + "Job is -> " + job );

    }
}
