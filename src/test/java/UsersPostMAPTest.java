import APICollections.API_Post_Request;
import APICollections.API_Post_RequestwithMAP;
import Constants.ConstantPaths;
import Utils.PropertyFileReading;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UsersPostMAPTest {
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
        API_Post_RequestwithMAP apiPostRequestwithMAP = new API_Post_RequestwithMAP();
        apiPostRequestwithMAP.setupRequestSpecification(userPostTestProp.getProperty("BaseURI"), userPostTestProp.getProperty("PostBasePath"));
        apiPostRequestwithMAP.postData("Palash","Soni");
        apiPostRequestwithMAP.postData("job","Leader");
        apiPostRequestwithMAP.postRequest(userPostTestProp.getProperty("PostBasePath"));

        System.out.println(apiPostRequestwithMAP.getStatusLine());
        System.out.println(apiPostRequestwithMAP.getBody());

    }
}
