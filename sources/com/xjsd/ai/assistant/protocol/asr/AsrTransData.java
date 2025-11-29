package com.xjsd.ai.assistant.protocol.asr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

public class AsrTransData {
    private String errorCode;
    private String id;
    private boolean isOfflineResult = false;
    @JsonIgnore
    @Expose(deserialize = false, serialize = false)
    private String offlineCmd;
    private String text;
    private int type;

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getId() {
        return this.id;
    }

    public String getOfflineCmd() {
        return this.offlineCmd;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public boolean isOfflineResult() {
        return this.isOfflineResult;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setOfflineCmd(String str) {
        this.offlineCmd = str;
    }

    public void setOfflineResult(boolean z) {
        this.isOfflineResult = z;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "AsrTransData{id='" + this.id + '\'' + ", text='" + this.text + '\'' + ", type=" + this.type + ", isOfflineResult=" + this.isOfflineResult + ", errorCode='" + this.errorCode + '\'' + '}';
    }
}
