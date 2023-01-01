package APICollections;//import java.util.*;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class API_Put_Request {
    Response response;
    RequestSpecification httpRequestSpecification;
    ResponseBody responseBody;

    public void setupRequestSpecification(String URI, String BASEPATH) {
        //Specify base URI
        RestAssured.baseURI = URI+"/";

        //request specification
        httpRequestSpecification = RestAssured.given();

        //capturing http request in response
        response = httpRequestSpecification.request(Method.GET,BASEPATH);

        /*httpRequestSpecification.baseUri(URI+"/").basePath(BASEPATH);*/
    }

    public String getStatusLine() {
        return response.statusLine();
    }
    public int getStatusCode()
    {
        return response.getStatusCode();
    }

    public String getBody() {
        responseBody = response.getBody();
        return responseBody.asPrettyString();
    }

    public String getQuery(String query) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get(query);
    }

    public String getHeader(String headerName) {
        return response.header(headerName);
    }

    public Map<String, String> getAllHeadersMap() {
        Headers allHeaders = response.headers();
        Map<String, String> headerMap = new HashMap<>();
        for (Header header : allHeaders) {
            headerMap.put(header.getName(), header.getValue());
        }
        return headerMap;
    }
}
