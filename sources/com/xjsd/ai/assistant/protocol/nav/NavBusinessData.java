package com.xjsd.ai.assistant.protocol.nav;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class NavBusinessData {
    public static final String ACCESS_BACKGROUND_LOCATION_LACK = "ACCESS_BACKGROUND_LOCATION_LACK";
    public static final int NAVI_EXIT = 1;
    public static final int NAVI_MUTE = 3;
    public static final int NAVI_PAGES = 2;
    public static final int NAVI_POI = 0;
    public static final int NAVI_TOAST = 4;
    private static Gson PARSER = new Gson();
    private Object payload;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface NavBusinessType {
    }

    public NavBusinessData(int i) {
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
