package com.xjsd.ai.assistant.protocol;

import com.google.gson.Gson;
import com.xjsd.ai.assistant.core.bean.SessionData;
import java.io.Serializable;

public class BusinessData extends SessionData implements Serializable {
    private static Gson PARSER = new Gson();
    private Object data;
    private BusinessDataType dataType;

    public BusinessData(BusinessDataType businessDataType, Object obj) {
        this.dataType = businessDataType;
        this.data = obj;
    }

    public Object getData() {
        return this.data;
    }

    public BusinessDataType getDataType() {
        return this.dataType;
    }

    public <K> K parseData(Class<K> cls) {
        Object obj = this.data;
        if (obj instanceof String) {
            PARSER.fromJson((String) obj, cls);
        }
        Gson gson = PARSER;
        return gson.fromJson(gson.toJson(this.data), cls);
    }
}
