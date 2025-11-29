package com.xjsd.ai.assistant.protocol.wechat;

public class WechatData {
    private String callerName;
    private String cmdType;
    private int contentTtsHintTimes;
    private boolean dialogueAbort;
    private int index;
    private String message;
    private String nlgId;
    private long postTime;
    private String target;

    public String getCallerName() {
        return this.callerName;
    }

    public String getCmdType() {
        return this.cmdType;
    }

    public int getContentTtsHintTimes() {
        return this.contentTtsHintTimes;
    }

    public int getIndex() {
        return this.index;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNlgId() {
        return this.nlgId;
    }

    public long getPostTime() {
        return this.postTime;
    }

    public String getTarget() {
        return this.target;
    }

    public boolean isDialogueAbort() {
        return this.dialogueAbort;
    }

    public void setCallerName(String str) {
        this.callerName = str;
    }

    public void setCmdType(String str) {
        this.cmdType = str;
    }

    public void setContentTtsHintTimes(int i) {
        this.contentTtsHintTimes = i;
    }

    public void setDialogueAbort(boolean z) {
        this.dialogueAbort = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNlgId(String str) {
        this.nlgId = str;
    }

    public void setPostTime(long j) {
        this.postTime = j;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public String toString() {
        return "WechatData{nlgId='" + this.nlgId + '\'' + ", target='" + this.target + '\'' + ", message='" + this.message + '\'' + ", cmdType='" + this.cmdType + '\'' + ", index=" + this.index + ", callerName='" + this.callerName + '\'' + ", postTime=" + this.postTime + ", dialogue_abort=" + this.dialogueAbort + '}';
    }
}
