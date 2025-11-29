package com.xjsd.ai.assistant.asr.engine.protocol;

import androidx.annotation.Keep;

@Keep
public class VadInfo {
    private String state;

    public String getState() {
        return this.state;
    }

    public VadInfo setState(String str) {
        this.state = str;
        return this;
    }

    public String toString() {
        return "VadInfo{state='" + this.state + '\'' + '}';
    }
}
