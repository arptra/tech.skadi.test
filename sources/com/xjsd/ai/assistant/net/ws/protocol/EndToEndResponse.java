package com.xjsd.ai.assistant.net.ws.protocol;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.lang.reflect.Type;

@Keep
public class EndToEndResponse {
    private static Gson PARSER = new Gson();
    private Object payload;
    private String requestId;
    private String type;

    public Object getPayload() {
        return this.payload;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getType() {
        return this.type;
    }

    public <T> T parsePayload(Class<T> cls) {
        Object obj = this.payload;
        if (obj instanceof String) {
            return PARSER.fromJson((String) obj, cls);
        }
        Gson gson = PARSER;
        return gson.fromJson(gson.toJson(obj), cls);
    }

    public void setPayload(Object obj) {
        this.payload = obj;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return PARSER.toJson((Object) this);
    }

    public <T> T parsePayload(Type type2) {
        Object obj = this.payload;
        if (obj instanceof String) {
            return PARSER.fromJson((String) obj, type2);
        }
        Gson gson = PARSER;
        return gson.fromJson(gson.toJson(obj), type2);
    }
}
