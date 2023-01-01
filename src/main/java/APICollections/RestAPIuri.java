package APICollections;//import java.util.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;


public class RestAPIuri {
    Logger logger = Logger.getLogger(getClass());
    Response response;

    public void API(String URI) {
        response = RestAssured.get("https://reqres.in/api/users?page=2");
        RestAssured.baseURI = URI;
    }

    public String getWholeBodyResponse() {
        logger.debug("Whole response");
        String body = response.asPrettyString();
        return body;
    }

    public String getResponseBody() {
        logger.debug("Response body");
        return response.getBody().asPrettyString();
    }

    public int getStatusCode() {
        logger.debug("Waiting for Status Code");
        return response.getStatusCode();
    }

    public String getStatusLine() {
        logger.debug("Waiting for Status Line");
        return response.statusLine();
    }

}
