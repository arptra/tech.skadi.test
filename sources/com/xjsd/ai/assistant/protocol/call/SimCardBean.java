package com.xjsd.ai.assistant.protocol.call;

public class SimCardBean {
    private String name;
    private String number;
    private int slotId;
    private int subId;

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public int getSlotId() {
        return this.slotId;
    }

    public int getSubId() {
        return this.subId;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setSlotId(int i) {
        this.slotId = i;
    }

    public void setSubId(int i) {
        this.subId = i;
    }

    public String toString() {
        return "SimCardBean{slotId=" + this.slotId + ", subId=" + this.subId + ", name='" + this.name + '\'' + ", number='" + this.number + '\'' + '}';
    }
}
