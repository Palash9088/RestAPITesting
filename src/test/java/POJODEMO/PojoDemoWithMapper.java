package POJODEMO;//import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class PojoDemoWithMapper {

    @Test
    public void createJsonFromJavaObject()
    {
        //Created object of pojo class and passed the values in constructor
        PojoMapper pojoMapper = new PojoMapper("Palash", "Soni","Quality Assurance",100000.0,"Pune");
        System.out.println("Direct PoJo Print -> " + pojoMapper);

        //Created the object of mapper class to serialize the java pojo object class
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // in try catch block so that program will not break,
            // Captured payload in json format  < - - - with the object of mapper we converted values in json & pass the object of POJO class
            String payloadInJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoMapper);
            System.out.println("Payload in Json format -> " +  payloadInJson);

        } catch (JsonProcessingException e) {
            System.out.println("Not able to convert into json");
        }
    }

    @Test
    public void convertingJsonIntoObject() throws JsonProcessingException {
        PojoMapper pojoMapper2 = new PojoMapper("Palak", "Soni", "Quality Assurance", 200000.0, "Pune");

        System.out.println("Direct PoJo Print -> " + pojoMapper2);

        //Created the object of mapper class to serialize the java pojo object class
        ObjectMapper objectMapper = new ObjectMapper();
        String payloadInJson = objectMapper.writeValueAsString(pojoMapper2);


        //Converting JSON to Java Object

        PojoMapper pojoMapper3 = new ObjectMapper().readValue(payloadInJson, PojoMapper.class);
        System.out.println("First Name -> " + pojoMapper3.getFirstName());
        System.out.println("Last Name -> " + pojoMapper3.getLastName());
        System.out.println("Department -> " + pojoMapper3.getDeptName());
        System.out.println("Salary -> " + pojoMapper3.getSalary());
        System.out.println("Location -> " + pojoMapper3.getLocation());


    }

}
