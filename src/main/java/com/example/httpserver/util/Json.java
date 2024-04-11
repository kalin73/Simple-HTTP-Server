package com.example.httpserver.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;

public class Json {
    private static final Gson OBJECT_MAPPER = defaultObjectMapper();

    private static Gson defaultObjectMapper() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    public static <T> T fromJson(Reader node, Class<T> clazz) {
        return OBJECT_MAPPER.fromJson(node, clazz);
    }

    public static String toJson(Object obj) {
        return OBJECT_MAPPER.toJson(obj);
    }
}
