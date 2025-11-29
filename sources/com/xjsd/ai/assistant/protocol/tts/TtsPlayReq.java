package com.xjsd.ai.assistant.protocol.tts;

import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;

public class TtsPlayReq {
    private String id;
    private boolean isContinuous;
    private boolean isMulti;
    private boolean isWakeup;
    private TtsData ttsData;
    private WakeupControl wakeupControl;

    public String getId() {
        return this.id;
    }

    public TtsData getTtsData() {
        return this.ttsData;
    }

    public WakeupControl getWakeupControl() {
        return this.wakeupControl;
    }

    public boolean isContinuous() {
        return this.isContinuous;
    }

    public boolean isMulti() {
        return this.isMulti;
    }

    public boolean isWakeup() {
        return this.isWakeup;
    }

    public void setContinuous(boolean z) {
        this.isContinuous = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMulti(boolean z) {
        this.isMulti = z;
    }

    public void setTtsData(TtsData ttsData2) {
        this.ttsData = ttsData2;
    }

    public void setWakeup(boolean z) {
        this.isWakeup = z;
    }

    public void setWakeupControl(WakeupControl wakeupControl2) {
        this.wakeupControl = wakeupControl2;
    }
}
