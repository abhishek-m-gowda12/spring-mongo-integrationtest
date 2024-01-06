package io.abhishek.springmongointegrationtest.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtils {
    public static <T> T readFromJson(String path, TypeReference<T> type) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("file does not exist + " + path);
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return objectMapper.readValue(fileInputStream, type);
        }
    }
}
