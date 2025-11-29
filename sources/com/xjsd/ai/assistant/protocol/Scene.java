package com.xjsd.ai.assistant.protocol;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface Scene {
    public static final String CALL = "CALL";
    public static final String CHAT_GPT = "CHAT_GPT";
    public static final String GPT = "GPT";
    public static final String NAVIGATION = "NAVI";
    public static final String NORMAL = "NORMAL";
    public static final String NOTIFICATION = "NOTIFICATION";
    public static final String WECHAT_RELAY = "WECHAT_RELAY";
    public static final String WECHAT_TRANSFER = "WECHAT_TRANSFER";
}
