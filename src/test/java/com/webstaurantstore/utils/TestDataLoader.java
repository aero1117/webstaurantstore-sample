package com.webstaurantstore.utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

// Class to load test data from a JSON file for better re-usability
public class TestDataLoader {
    private static JsonNode rootNode;

    static {
        try { // Use ObjectMapper class to read the JSON file and map to key/value pairs
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/test/resources/testdata.json");
            rootNode = objectMapper.readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTestData(String path, String key) {  // Our method to be used in test classes
        return rootNode.path(path).path(key).asText();
    }
}