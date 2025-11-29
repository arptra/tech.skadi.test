package com.xjsd.ai.assistant.protocol;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface WakeupType {
    public static final int ASR_AND_NLU = 11;
    public static final int ASR_ONLY = 3;
    public static final int CHAT_GPT_LAUNCH = 10;
    public static final int CONTINUOUS_LAUNCH = 6;
    public static final int CUSTOMIZED_LAUNCH = 4;
    public static final int KEEP_LISTENING_LAUNCH = 8;
    public static final int LISTENING_FOR_REJECT_LAUNCH = 9;
    public static final int LOW_POWER_LAUNCH = 5;
    public static final int MULTI_LAUNCH = 2;
    public static final int NORMAL_LAUNCH = 1;
    public static final int WAKEUP_WORD_LAUNCH = 7;
}
