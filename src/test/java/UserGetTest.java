import APICollections.API_Get_Request;
import Constants.ConstantPaths;
import Utils.PropertyFileReading;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class UserGetTest {
    PropertyFileReading userTestProp;

    @BeforeClass
    public void readProp() {

        try {
            userTestProp = new PropertyFileReading(ConstantPaths.PROP_PATH + "APILinks.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void reqresApiTest() {
        API_Get_Request api_get_request = new API_Get_Request();
        api_get_request.setupRequestSpecification(userTestProp.getProperty("BaseURI"), userTestProp.getProperty("BasePath"));
        String body = api_get_request.getBody();
        System.out.println(body);
    }
}
