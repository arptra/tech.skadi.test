package com.tekartik.sqflite;

import android.database.sqlite.SQLiteProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlCommand {

    /* renamed from: a  reason: collision with root package name */
    public final String f10031a;
    public final List b;

    public SqlCommand(String str, List list) {
        this.f10031a = str;
        this.b = list == null ? new ArrayList() : list;
    }

    public static Object f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bArr[i] = (byte) ((Integer) list.get(i)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        List list = this.b;
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                Object f = f(this.b.get(i));
                int i2 = i + 1;
                if (f == null) {
                    sQLiteProgram.bindNull(i2);
                } else if (f instanceof byte[]) {
                    sQLiteProgram.bindBlob(i2, (byte[]) f);
                } else if (f instanceof Double) {
                    sQLiteProgram.bindDouble(i2, ((Double) f).doubleValue());
                } else if (f instanceof Integer) {
                    sQLiteProgram.bindLong(i2, (long) ((Integer) f).intValue());
                } else if (f instanceof Long) {
                    sQLiteProgram.bindLong(i2, ((Long) f).longValue());
                } else if (f instanceof String) {
                    sQLiteProgram.bindString(i2, (String) f);
                } else if (f instanceof Boolean) {
                    sQLiteProgram.bindLong(i2, ((Boolean) f).booleanValue() ? 1 : 0);
                } else {
                    throw new IllegalArgumentException("Could not bind " + f + " from index " + i + ": Supported types are null, byte[], double, long, boolean and String");
                }
                i = i2;
            }
        }
    }

    public List b() {
        return this.b;
    }

    public String c() {
        return this.f10031a;
    }

    public Object[] d() {
        return e(this.b);
    }

    public final Object[] e(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object f : list) {
                arrayList.add(f(f));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SqlCommand)) {
            return false;
        }
        SqlCommand sqlCommand = (SqlCommand) obj;
        String str = this.f10031a;
        if (str != null) {
            if (!str.equals(sqlCommand.f10031a)) {
                return false;
            }
        } else if (sqlCommand.f10031a != null) {
            return false;
        }
        if (this.b.size() != sqlCommand.b.size()) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (!(this.b.get(i) instanceof byte[]) || !(sqlCommand.b.get(i) instanceof byte[])) {
                if (!this.b.get(i).equals(sqlCommand.b.get(i))) {
                    return false;
                }
            } else if (!Arrays.equals((byte[]) this.b.get(i), (byte[]) sqlCommand.b.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f10031a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10031a);
        List list = this.b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + this.b;
        }
        sb.append(str);
        return sb.toString();
    }
}
