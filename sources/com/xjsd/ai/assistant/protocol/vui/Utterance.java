package com.xjsd.ai.assistant.protocol.vui;

import java.io.Serializable;

public class Utterance implements Serializable {
    private String id;
    private String screen;
    private String speech;

    public String getId() {
        return this.id;
    }

    public String getScreen() {
        return this.screen;
    }

    public String getSpeech() {
        return this.speech;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setScreen(String str) {
        this.screen = str;
    }

    public void setSpeech(String str) {
        this.speech = str;
    }

    public String toString() {
        return "DomainUtterance{speech='" + this.speech + '\'' + ", screen='" + this.screen + '\'' + ", id='" + this.id + '\'' + '}';
    }
}
