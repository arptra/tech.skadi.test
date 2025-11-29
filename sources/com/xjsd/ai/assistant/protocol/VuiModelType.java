package com.xjsd.ai.assistant.protocol;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface VuiModelType {
    public static final String ACCESSIBILITY = "ACCESSIBILITY";
    public static final String ALARM = "alarm";
    public static final String APPLICATION = "application";
    public static final String CHAT_GPT = "llm";
    public static final String CHAT_GPT_ERROR = "CHAT_GPT_ERROR";
    public static final String CURRENT_NOT_ALLOWED = "currentNotAllowed";
    public static final String ERROR = "error";
    public static final String FREE_CHAT = "freechat";
    public static final String GLOBAL = "global";
    public static final String INNER_STKS = "INNER_STKS";
    public static final String MEDIA = "media";
    public static final String NAVIGATION = "navigation";
    public static final String PHONE = "phonecall";
    public static final String SCHEDULE = "schedule";
    public static final String SYSTEM_SETTING = "systemsetting";
    public static final String TODO = "todo";
    public static final String TRANSLATION = "translation";
    public static final String VSP_ERROR = "VSP_ERROR";
    public static final String WEATHER = "weather";
    public static final String WECHAT = "wechat";
}
