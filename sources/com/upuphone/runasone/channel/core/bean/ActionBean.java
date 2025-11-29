package com.upuphone.runasone.channel.core.bean;

public class ActionBean {
    private int actionType;
    private String data;

    public int getActionType() {
        return this.actionType;
    }

    public String getData() {
        return this.data;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public void setData(String str) {
        this.data = str;
    }
}
