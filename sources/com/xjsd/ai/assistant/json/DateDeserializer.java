package com.xjsd.ai.assistant.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.xjsd.ai.assistant.log.ILog;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer<Date> {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDateFormat f8497a;

    public DateDeserializer(String str) {
        this.f8497a = new SimpleDateFormat(str);
    }

    /* renamed from: a */
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            return this.f8497a.parse(jsonElement.getAsString());
        } catch (ParseException e) {
            ILog.b("DateDeserializer", "deserialize: 反序列化date失败", e);
            return null;
        }
    }
}
