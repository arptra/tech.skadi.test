package com.xjsd.ai.assistant.nlu.bean;

public class TalkInfo {
    private String id;
    private boolean isFinal;
    private String text;

    public TalkInfo() {
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    public void setFinal(boolean z) {
        this.isFinal = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public TalkInfo(String str, String str2, boolean z) {
        this.id = str;
        this.text = str2;
        this.isFinal = z;
    }
}
