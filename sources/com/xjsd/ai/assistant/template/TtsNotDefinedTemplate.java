package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsNotDefinedTemplate implements TtsTemplate {
    ALARM04_R05(R.string.tts_alarm04_r05, "ALARM04_R05"),
    ALARM04_R06(R.string.tts_alarm04_r06, "ALARM04_R06");
    
    private final String functionId;
    private final int resId;

    private TtsNotDefinedTemplate(int i, String str) {
        this.resId = i;
        this.functionId = str;
    }

    public String getFunctionId() {
        return this.functionId;
    }

    public int getResId() {
        return this.resId;
    }
}
