package Utils;//import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileReading {

    private Properties prop;

    public PropertyFileReading(String path) throws IOException {
        File file = new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);

        prop = new Properties();
        prop.load(fileInputStream);
    }

    public String getProperty(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return prop.getProperty(key);
    }
}
