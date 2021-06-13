package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    private static final InputStream CONFIG_PROPS = TestConfig.class
            .getResourceAsStream("/config.properties");

    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(CONFIG_PROPS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
