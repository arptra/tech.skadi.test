package com.tekartik.sqflite.operation;

public interface OperationResult {
    void error(String str, String str2, Object obj);

    void success(Object obj);
}
