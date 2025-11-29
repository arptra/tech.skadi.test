package com.here.odnp.util;

public class ObjectHolder<T> {
    private volatile T mObject;

    public ObjectHolder() {
    }

    public T get() {
        return this.mObject;
    }

    public void set(T t) {
        this.mObject = t;
    }

    public ObjectHolder(T t) {
        this.mObject = t;
    }
}
