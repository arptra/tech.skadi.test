package com.tekartik.sqflite.operation;

import com.tekartik.sqflite.SqlCommand;
import java.util.List;

public abstract class BaseReadOperation implements Operation {
    public SqlCommand c() {
        return new SqlCommand(j(), k());
    }

    public boolean d() {
        return b("transactionId") && g() == null;
    }

    public Boolean e() {
        return h("inTransaction");
    }

    public boolean f() {
        return Boolean.TRUE.equals(a("noResult"));
    }

    public Integer g() {
        return (Integer) a("transactionId");
    }

    public final Boolean h(String str) {
        Object a2 = a(str);
        if (a2 instanceof Boolean) {
            return (Boolean) a2;
        }
        return null;
    }

    public boolean i() {
        return Boolean.TRUE.equals(a("continueOnError"));
    }

    public final String j() {
        return (String) a("sql");
    }

    public final List k() {
        return (List) a("arguments");
    }

    public String toString() {
        return getMethod() + " " + j() + " " + k();
    }
}
