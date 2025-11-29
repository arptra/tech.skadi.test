package com.xjsd.ai.assistant.nlg;

public class NlgTts {
    private String mode;
    private String tts;

    public String getMode() {
        return this.mode;
    }

    public String getTts() {
        return this.tts;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setTts(String str) {
        this.tts = str;
    }

    public String toString() {
        return "NlgTts{tts='" + this.tts + '\'' + ", mode='" + this.mode + '\'' + '}';
    }
}
