package com.xjsd.ai.assistant.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.xjsd.ai.assistant.log.ILog;
import java.io.IOException;

public class JsonUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final ObjectMapper f8499a;

    static {
        ObjectMapper enable = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true).enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT).enable(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY).enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        SerializationFeature serializationFeature = SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
        ObjectMapper serializationInclusion = enable.configure(serializationFeature, false).setSerializationInclusion(JsonInclude.Include.NON_NULL);
        f8499a = serializationInclusion;
        serializationInclusion.registerModule(new JavaTimeModule());
        serializationInclusion.configure(serializationFeature, false);
    }

    public static Object a(String str, Class cls) {
        try {
            return f8499a.readValue(str, cls);
        } catch (IOException e) {
            ILog.h("JsonUtil", "捕获异常", e);
            return null;
        }
    }

    public static ObjectMapper b() {
        return f8499a;
    }

    public static String c(Object obj) {
        try {
            return f8499a.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            ILog.h("JsonUtil", "捕获异常", e);
            return null;
        }
    }
}
