package com.xjsd.ai.assistant.protocol.wechat;

import java.io.Serializable;

public class WechatCallStateBean implements Serializable {
    private String action;
    private long callDuration;
    private int callState;
    private int callType;
    private String target;

    public String getAction() {
        return this.action;
    }

    public long getCallDuration() {
        return this.callDuration;
    }

    public int getCallState() {
        return this.callState;
    }

    public int getCallType() {
        return this.callType;
    }

    public String getTarget() {
        return this.target;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setCallDuration(long j) {
        this.callDuration = j;
    }

    public void setCallState(int i) {
        this.callState = i;
    }

    public void setCallType(int i) {
        this.callType = i;
    }

    public void setTarget(String str) {
        this.target = str;
    }
}
