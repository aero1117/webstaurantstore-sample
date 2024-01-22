package com.webstaurantstore.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Class to handle properties from a config file in case we need to change URLs later
public class PropertiesLoader {
    private static Properties properties;
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
