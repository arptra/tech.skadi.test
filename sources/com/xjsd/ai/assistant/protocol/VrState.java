package com.xjsd.ai.assistant.protocol;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface VrState {
    public static final int CALL_NOT_HIT = 5;
    public static final int CLOSE = 0;
    public static final int CONTINUOUS_WAKEUP = 2;
    public static final int MULTI_WAKEUP = 1;
    public static final int TTS_PLAY_END = 4;
    public static final int TTS_PLAY_START = 3;
    public static final int VOICE_CHECK_FAILED = 12;
    public static final int VOICE_CHECK_SUCCESS = 11;
    public static final int VR_LISTENING_TIMEOUT = 8;
    public static final int VR_PROCESSION = 7;
    public static final int VR_REJECT = 6;
    public static final int VR_RESET_TIMEOUT = 9;
    public static final int VR_SHOW_REJECT = 10;
}
