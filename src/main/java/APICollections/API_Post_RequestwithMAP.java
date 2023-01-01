package APICollections;//import java.util.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class API_Post_RequestwithMAP {
    Response response;
    RequestSpecification httpRequestSpecification;
    ResponseBody responseBody;

    public void setupRequestSpecification(String URI, String BASEPATH) {
        //Specify base URI
        RestAssured.baseURI = URI+"/";

        //request specification
        httpRequestSpecification = RestAssured.given();

        //capturing http request in response

        //commented below as we are posting
        //response = httpRequestSpecification.request(Method.POST,BASEPATH);
        /*httpRequestSpecification.baseUri(URI+"/").basePath(BASEPATH);*/


    }

    public void postData(Object key, Object value)
    {
        httpRequestSpecification.contentType(ContentType.JSON);
        Map<Object, Object> payload = new HashMap<>();
        payload.put(key,value);

        httpRequestSpecification.body(payload);

    }
    public void postRequest(String BASEPATH)
    {
        response = httpRequestSpecification.request(Method.POST,BASEPATH);
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
