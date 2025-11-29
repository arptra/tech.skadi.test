package com.xjsd.ai.assistant.nlu.bean;

import java.util.List;

public class PayloadData {
    private List<Object> data;
    private boolean increment;
    private String q;
    private String sign;
    private String type;

    public List<Object> getData() {
        return this.data;
    }

    public String getQ() {
        return this.q;
    }

    public String getSign() {
        return this.sign;
    }

    public String getType() {
        return this.type;
    }

    public boolean isIncrement() {
        return this.increment;
    }

    public void setData(List<Object> list) {
        this.data = list;
    }

    public void setIncrement(boolean z) {
        this.increment = z;
    }

    public void setQ(String str) {
        this.q = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
