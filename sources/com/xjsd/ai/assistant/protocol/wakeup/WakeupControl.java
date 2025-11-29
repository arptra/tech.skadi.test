package com.xjsd.ai.assistant.protocol.wakeup;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class WakeupControl {
    public static final int ASR_AND_NLU_LAUNCH = 11;
    public static final int ASR_LAUNCH = 3;
    public static final int CHAT_GPT_LAUNCH = 10;
    public static final int CLOSE = 0;
    public static final int CONTINUOUS_LAUNCH = 6;
    public static final int CUSTOMIZED_LAUNCH = 4;
    public static final int LOW_POWER_LAUNCH = 5;
    public static final int MULTI_LAUNCH = 2;
    public static final int NORMAL_LAUNCH = 1;
    public static final int WAKEUP_WORD_LAUNCH = 7;
    @Control
    private int control;
    private String extra;
    private long muteTimeout = AssistantConstants.TIMEOUT_VAD_MUTE;
    @Scene
    private String scene = Scene.NORMAL;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.CLASS)
    public @interface Control {
    }

    public WakeupControl(@Control int i) {
        this.control = i;
    }

    @Control
    public int getControl() {
        return this.control;
    }

    public String getExtra() {
        return this.extra;
    }

    public Long getMuteTimeout() {
        return Long.valueOf(this.muteTimeout);
    }

    @Scene
    public String getScene() {
        return this.scene;
    }

    public void setControl(int i) {
        this.control = i;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMuteTimeout(Long l) {
        this.muteTimeout = l.longValue();
    }

    public void setScene(@Scene String str) {
        this.scene = str;
    }
}
