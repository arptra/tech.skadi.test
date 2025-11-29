package com.xjsd.ai.assistant.protocol.setting;

public class SettingBusinessData {
    private String nlgId;
    private String operation;
    private String target;

    public String getNlgId() {
        return this.nlgId;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getTarget() {
        return this.target;
    }

    public void setNlgId(String str) {
        this.nlgId = str;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public void setTarget(String str) {
        this.target = str;
    }
}
