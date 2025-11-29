package com.xjsd.ai.assistant.protocol.wechat;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class WechatBusinessData {
    private static Gson PARSER = new Gson();
    public static final int WECHAT_CALL_STATE = 2;
    public static final int WECHAT_CMD = 0;
    public static final int WECHAT_CONFIRM_RESULT = 5;
    public static final int WECHAT_FILL_CONTENT = 6;
    public static final int WECHAT_LINKMAN_LIST = 1;
    public static final int WECHAT_REPLY_RESULT = 4;
    public static final int WECHAT_SEND_CONFIRM = 3;
    public static final int WECHAT_SHOW_HINT = 8;
    public static final int WECHAT_VAD_PAUSE_TIME = 7;
    private Object payload;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface WechatBusinessType {
    }

    public WechatBusinessData(int i) {
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
