package com.xjsd.ai.assistant.protocol.alarm;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AlarmBusinessData {
    public static final int ALARM_ADD = 2;
    public static final int ALARM_DELETE = 3;
    public static final int ALARM_DISMISS = 7;
    public static final int ALARM_LIST = 0;
    public static final int ALARM_MODIFY = 4;
    public static final int ALARM_PAGES = 1;
    public static final int ALARM_SELECT = 5;
    public static final int ALARM_VIEW = 6;
    private static final Gson PARSER = new Gson();
    private Object payload;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface AlarmBusinessType {
    }

    public AlarmBusinessData(int i) {
        this.type = i;
    }

    public Object getPayload() {
        return this.payload;
    }

    public int getType() {
        return this.type;
    }

    public <K> K parsePayload(Class<K> cls) {
        Gson gson = PARSER;
        return gson.fromJson(gson.toJson(this.payload), cls);
    }

    public void setPayload(Object obj) {
        this.payload = obj;
    }

    public String toString() {
        return PARSER.toJson((Object) this);
    }
}
