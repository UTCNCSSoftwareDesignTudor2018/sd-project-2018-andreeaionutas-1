package com.aionutas.pizzaorderingsystem.model.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converters {
    public static <T> T getObjectFromJson(String json, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
           // LOGGER.error("Conversion to object from json failed: {}", e);
            throw new RuntimeException(e);
        }
    }
}
