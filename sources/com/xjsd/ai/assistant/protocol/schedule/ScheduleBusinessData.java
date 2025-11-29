package com.xjsd.ai.assistant.protocol.schedule;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ScheduleBusinessData {
    private static Gson PARSER = new Gson();
    public static final int SCHEDULE_ADD = 2;
    public static final int SCHEDULE_DELETE = 3;
    public static final int SCHEDULE_DISMISS = 7;
    public static final int SCHEDULE_LIST = 0;
    public static final int SCHEDULE_MODIFY = 4;
    public static final int SCHEDULE_PAGES = 1;
    public static final int SCHEDULE_SELECT = 5;
    public static final int SCHEDULE_VIEW = 6;
    private Object payload;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScheduleBusinessType {
    }

    public ScheduleBusinessData(int i) {
        this.type = i;
    }

    public static final String getScheduleType(int i) {
        String.valueOf(i);
        switch (i) {
            case 0:
                return "SCHEDULE_LIST";
            case 1:
                return "SCHEDULE_PAGES";
            case 2:
                return "SCHEDULE_ADD";
            case 3:
                return "SCHEDULE_DELETE";
            case 4:
                return "SCHEDULE_MODIFY";
            case 5:
                return "SCHEDULE_SELECT";
            case 6:
                return "SCHEDULE_VIEW";
            case 7:
                return "SCHEDULE_DISMISS";
            default:
                return String.valueOf(i);
        }
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
