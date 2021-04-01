package org.pentaho.di.ui.repo.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author panmingjun
 * @date 2020/10/14 6:23 下午
 * @description
 */
public class JsonUtil {
    static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJson(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJson(String content, Class<T> valueType) throws IOException {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static <T> T fromJson(String content, TypeReference<T> valueType) throws IOException {
        try {
            return objectMapper.readValue(content,valueType);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
