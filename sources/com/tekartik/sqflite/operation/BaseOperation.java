package com.tekartik.sqflite.operation;

public abstract class BaseOperation extends BaseReadOperation {
    public void error(String str, String str2, Object obj) {
        l().error(str, str2, obj);
    }

    public abstract OperationResult l();

    public void success(Object obj) {
        l().success(obj);
    }
}
