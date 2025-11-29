package com.here.odnp.util;

public abstract class HandlerTask<T> implements Runnable {
    private static final String TAG = "odnp.util.HandlerTask";
    private T mResult;

    public T getResult() {
        return this.mResult;
    }

    public void onError(Error error) {
    }

    public void onException(Exception exc) {
    }

    public abstract T onRun();

    public void run() {
        try {
            setResult(onRun());
        } catch (Exception e) {
            onException(e);
        } catch (Error e2) {
            onError(e2);
        }
    }

    public void setResult(T t) {
        this.mResult = t;
    }
}
