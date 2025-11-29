package com.tekartik.sqflite;

import android.database.Cursor;
import android.util.Log;
import com.tekartik.sqflite.dev.Debug;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static List a(Cursor cursor, int i) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            Object b = b(cursor, i2);
            if (Debug.c) {
                if (b == null) {
                    str = null;
                } else if (b.getClass().isArray()) {
                    str = "array(" + b.getClass().getComponentType().getName() + ")";
                } else {
                    str = b.getClass().getName();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i2);
                sb.append(" ");
                sb.append(cursor.getType(i2));
                sb.append(": ");
                sb.append(b);
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = " (" + str + ")";
                }
                sb.append(str2);
                Log.d("Sqflite", sb.toString());
            }
            arrayList.add(b);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i);
    }

    public static Locale c(String str) {
        return Locale.forLanguageTag(str);
    }

    public static Locale d(String str) {
        return c(str);
    }
}
