package com.xjsd.ai.assistant.nlu.bean;

import java.util.List;

public class UploadInfo<T> {
    private final List<T> data;
    private boolean increment;
    private String type;

    public UploadInfo(List<T> list) {
        this.data = list;
    }

    public List<T> getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public boolean isIncrement() {
        return this.increment;
    }

    public void setIncrement(boolean z) {
        this.increment = z;
    }

    public void setType(String str) {
        this.type = str;
    }
}
