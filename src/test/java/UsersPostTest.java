import APICollections.API_Post_Request;
import Constants.ConstantPaths;
import Utils.PropertyFileReading;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UsersPostTest {
    PropertyFileReading userPostTestProp;

    @BeforeClass
    public void readProp() {

        try {
            userPostTestProp = new PropertyFileReading(ConstantPaths.PROP_PATH + "APILinks.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void postData() {
        API_Post_Request apiPostRequest = new API_Post_Request();
        apiPostRequest.setupRequestSpecification(userPostTestProp.getProperty("BaseURI"), userPostTestProp.getProperty("PostBasePath"));
        apiPostRequest.postData("name", "Palash");
        apiPostRequest.postData("job", "Leader");
        apiPostRequest.postRequest(userPostTestProp.getProperty("PostBasePath"));
        String body = apiPostRequest.getBody();
        int statusCode = apiPostRequest.getStatusCode();
        System.out.println(body);
        System.out.println(statusCode);

    }
}
