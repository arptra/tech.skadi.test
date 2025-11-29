package com.xjsd.ai.assistant.protocol.todo;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xjsd.ai.assistant.json.DateDeserializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

public class TodoBusinessData {
    private static Gson PARSER = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer("yyyy-MM-dd HH:mm:ss")).enableComplexMapKeySerialization().create();
    public static final int TODO_CRATE_LIST = 0;
    public static final int TODO_DELETE_LIST = 1;
    public static final int TODO_DELETE_SELECT = 4;
    public static final int TODO_QUERY_LIST = 3;
    public static final int TODO_QUERY_SELECT = 6;
    public static final int TODO_UPDATE_LIST = 2;
    public static final int TODO_UPDATE_SELECT = 5;
    private Object payload;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface TodoBusinessType {
    }

    public TodoBusinessData(int i) {
        this.type = i;
    }

    public Object getPayload() {
        return this.payload;
    }

    public int getType() {
        return this.type;
    }

    public <K> K parse(Class<K> cls) {
        Object obj = this.payload;
        if (obj instanceof String) {
            PARSER.fromJson((String) obj, cls);
        }
        Gson gson = PARSER;
        return gson.fromJson(gson.toJson(this.payload), cls);
    }

    public void setPayload(Object obj) {
        this.payload = obj;
    }

    public void setType(int i) {
        this.type = i;
    }
}
