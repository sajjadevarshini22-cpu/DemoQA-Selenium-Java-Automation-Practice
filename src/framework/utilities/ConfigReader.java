package framework.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;
    public static void loadProperties() {

        try {
            FileInputStream file = new FileInputStream("config/config.properties");

            properties = new Properties();

            properties.load(file);

        } catch (IOException e) {
            System.out.println("Config file not found: " + e.getMessage());
        }
    }
    public static String getProperty(String key) {

        if (properties == null) {
            loadProperties();
        }

        return properties.getProperty(key);
    }

}
