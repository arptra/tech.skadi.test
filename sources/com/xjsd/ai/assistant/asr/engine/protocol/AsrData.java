package com.xjsd.ai.assistant.asr.engine.protocol;

import androidx.annotation.Keep;

@Keep
public class AsrData {
    private String accent;
    private String language;
    private String text;

    public String getAccent() {
        return this.accent;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getText() {
        return this.text;
    }

    public void setAccent(String str) {
        this.accent = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
