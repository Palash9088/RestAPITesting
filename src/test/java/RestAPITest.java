import APICollections.API_Get_Request;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class RestAPITest extends TestBase {
    Logger logger = Logger.getLogger(RestAPITest.class);


    @Test
    public void verifyTest() {
        /*RestAPIuri restAPIuri = new RestAPIuri();
        restAPIuri.API("https://reqres.in/api/users/2");
        String statusLine = restAPIuri.getStatusLine();
        String responseBody = restAPIuri.getWholeBodyResponse();
        int statusCode = restAPIuri.getStatusCode();
        logger.info(statusLine);
        logger.info(responseBody);
        logger.info(statusCode);*/

        API_Get_Request api_get_request = new API_Get_Request();
        api_get_request.setupRequestSpecification("https://reqres.in", "api/unknown");
        System.out.println(api_get_request.getBody());
        String actual = api_get_request.getQuery("data[0].name");
        //Assert.assertEquals(actual,"fuchsia rose");
        System.out.println(actual);
        System.out.println(api_get_request.getHeader("Content-Type"));

        Map<String,String> headersMap = api_get_request.getAllHeadersMap();
        boolean flag = headersMap.containsKey("Transfer-Encoding");
        String val = headersMap.get("Transfer-Encoding");
        System.out.println(headersMap);

    }
}
