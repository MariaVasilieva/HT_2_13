package org.example.config;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
