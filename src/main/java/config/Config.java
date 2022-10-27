package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static Properties prop;
    private final static String ABS_PATH = System.getProperty("user.dir");
    private final static String RELATIVE_PATH = File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
    private final static String DOC_PATH = ABS_PATH + RELATIVE_PATH;
    public static File propertiesFile = new File(DOC_PATH);

    public static Properties loadProperties() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream(propertiesFile)) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


}
