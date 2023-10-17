package org.example.core;

import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@UtilityClass
public class PropertyReader {
    private static final Properties properties = new Properties();

    public static void loadConfig(String propertyFileName) {
        try {
            properties.load(new FileInputStream("src/main/resources/" + propertyFileName + ".properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
