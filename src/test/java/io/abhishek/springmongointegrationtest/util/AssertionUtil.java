package io.abhishek.springmongointegrationtest.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class AssertionUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer =
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        javaTimeModule.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.findAndRegisterModules();
        OBJECT_MAPPER.registerModule(javaTimeModule);
    }

    public void assertJsonArray(String dir, List list) throws IOException, JSONException {
        try (FileInputStream fileInputStream = new FileInputStream(dir)) {
            String jsonString = new String(fileInputStream.readAllBytes());

            JSONArray expectedArray = new JSONArray(jsonString);
            JSONArray actualArray = new JSONArray(OBJECT_MAPPER.writeValueAsString(list));

            JSONAssert.assertEquals(expectedArray, actualArray, JSONCompareMode.LENIENT);
        }
    }

    public void assertJsonObject(String dir, Object object) throws IOException, JSONException {
        try (FileInputStream fileInputStream = new FileInputStream(dir)) {
            String jsonString = new String(fileInputStream.readAllBytes());

            JSONObject expectedArray = new JSONObject(jsonString);
            JSONObject actualArray = new JSONObject(OBJECT_MAPPER.writeValueAsString(object));

            JSONAssert.assertEquals(expectedArray, actualArray, JSONCompareMode.LENIENT);
        }
    }
}
