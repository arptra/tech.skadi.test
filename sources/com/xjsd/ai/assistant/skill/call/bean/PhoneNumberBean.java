package com.xjsd.ai.assistant.skill.call.bean;

import java.io.Serializable;

public class PhoneNumberBean implements Serializable {
    private String num;
    private int type;

    public PhoneNumberBean(int i, String str) {
        this.type = i;
        this.num = str;
    }

    public String getNum() {
        return this.num;
    }

    public int getType() {
        return this.type;
    }

    public void setNum(String str) {
        this.num = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "PhoneNumber{type=" + this.type + ", num='" + this.num + '\'' + '}';
    }
}
