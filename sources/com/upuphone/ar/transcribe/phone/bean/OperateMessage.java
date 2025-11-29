package com.upuphone.ar.transcribe.phone.bean;

public class OperateMessage<T> {
    private T object;
    private int type;

    public OperateMessage(int i) {
        this.type = i;
    }

    public T getObject() {
        return this.object;
    }

    public int getType() {
        return this.type;
    }

    public void setObject(T t) {
        this.object = t;
    }

    public void setType(int i) {
        this.type = i;
    }

    public OperateMessage(int i, T t) {
        this.type = i;
        this.object = t;
    }
}
