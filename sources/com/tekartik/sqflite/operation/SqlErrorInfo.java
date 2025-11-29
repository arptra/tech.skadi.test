package com.tekartik.sqflite.operation;

import com.tekartik.sqflite.SqlCommand;
import java.util.HashMap;
import java.util.Map;

public class SqlErrorInfo {
    public static Map a(Operation operation) {
        SqlCommand c = operation.c();
        if (c == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sql", c.c());
        hashMap.put("arguments", c.b());
        return hashMap;
    }
}
