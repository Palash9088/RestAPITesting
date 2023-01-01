import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    @BeforeClass
    public void beforeClassExecution() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
        System.setProperty("current.date.time", sdf.format(new Date()));
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
}
