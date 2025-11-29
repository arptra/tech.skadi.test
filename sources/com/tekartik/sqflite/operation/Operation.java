package com.tekartik.sqflite.operation;

import com.tekartik.sqflite.SqlCommand;

public interface Operation extends OperationResult {
    Object a(String str);

    boolean b(String str);

    SqlCommand c();

    boolean d();

    Boolean e();

    boolean f();

    Integer g();

    String getMethod();
}
