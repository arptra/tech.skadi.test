package com.xjsd.ai.assistant.protocol.tts;

public class TtsPlayRes {
    private String id;
    private boolean isContinuous;
    private boolean isMulti;
    private boolean isWakeup;
    private int playState;

    public String getId() {
        return this.id;
    }

    public int getPlayState() {
        return this.playState;
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

    public void setPlayState(int i) {
        this.playState = i;
    }

    public void setWakeup(boolean z) {
        this.isWakeup = z;
    }
}
