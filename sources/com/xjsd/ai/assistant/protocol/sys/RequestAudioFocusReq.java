package com.xjsd.ai.assistant.protocol.sys;

public class RequestAudioFocusReq {
    private String action;
    private String id;
    private String mode;

    public String getAction() {
        return this.action;
    }

    public String getId() {
        return this.id;
    }

    public String getMode() {
        return this.mode;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String toString() {
        return "RequestAudioFocusReq{id='" + this.id + '\'' + ", mode='" + this.mode + '\'' + ", action='" + this.action + '\'' + '}';
    }
}
