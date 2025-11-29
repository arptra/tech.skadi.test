package com.meizu.net.pedometerprovider.manager.bean;

public class StepBean {
    int count;
    long data;

    public StepBean(long j, int i) {
        this.data = j;
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public long getData() {
        return this.data;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setData(int i) {
        this.data = (long) i;
    }
}
