package com.xjsd.ai.assistant.protocol.call;

public class ReplyPhoneCallBean {
    private String callerNum;
    private String name;
    private int simIndex;

    public String getCallerNum() {
        return this.callerNum;
    }

    public String getName() {
        return this.name;
    }

    public int getSimIndex() {
        return this.simIndex;
    }

    public void setCallerNum(String str) {
        this.callerNum = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSimIndex(int i) {
        this.simIndex = i;
    }

    public String toString() {
        return "ReplyPhoneCallBean{  name='" + this.name + '\'' + ", callerNum='" + this.callerNum + '\'' + ", simIndex=" + this.simIndex + '}';
    }
}
