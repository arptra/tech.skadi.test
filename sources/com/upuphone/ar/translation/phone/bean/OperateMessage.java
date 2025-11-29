package com.upuphone.ar.translation.phone.bean;

public class OperateMessage<T> {
    private T operateObject;
    private int type;

    public OperateMessage(int i) {
        this.type = i;
    }

    public T getOperateObject() {
        return this.operateObject;
    }

    public int getType() {
        return this.type;
    }

    public void setOperateObject(T t) {
        this.operateObject = t;
    }

    public void setType(int i) {
        this.type = i;
    }

    public OperateMessage(int i, T t) {
        this.type = i;
        this.operateObject = t;
    }
}
