package com.netease.nis.sdkwrapper;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.common.widget.MzContactsContract;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Utils {
    static {
        System.loadLibrary("secsdk");
    }

    public static String a(String str) {
        if (str.startsWith("[")) {
            return str.replace(".", "/");
        }
        if (str.equals("int")) {
            return "I";
        }
        if (str.equals("float")) {
            return "F";
        }
        if (str.equals("long")) {
            return "J";
        }
        if (str.equals("double")) {
            return "D";
        }
        if (str.equals("short")) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (str.equals("char")) {
            return "C";
        }
        if (str.equals("boolean")) {
            return "Z";
        }
        if (str.equals("byte")) {
            return "B";
        }
        return ("L" + str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD).replace(".", "/");
    }

    public static String b(Class cls, String str, String str2) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                String replace = field.getType().toString().replace("class ", "").replace("interface ", "");
                if (Modifier.isStatic(field.getModifiers()) && field.getName().equals(str) && str2.equals(a(replace))) {
                    return field.getDeclaringClass().getName().replace(".", "/");
                }
            }
            return "";
        } catch (NoClassDefFoundError unused) {
            return "NoClassDefFoundError";
        }
    }

    public static String getFieldSCDesc(Class cls, String str, String str2) {
        while (cls != null) {
            String b = b(cls, str, str2);
            if (b != "") {
                return b;
            }
            cls = cls.getSuperclass();
        }
        return "";
    }

    public static Object getStaticFO(String str, String str2) {
        try {
            Field field = Class.forName(str.replace('/', '.')).getField(str2);
            Class<?> type = field.getType();
            return type == Integer.TYPE ? Integer.valueOf(field.getInt((Object) null)) : type == Float.TYPE ? Float.valueOf(field.getFloat((Object) null)) : type == Long.TYPE ? Long.valueOf(field.getLong((Object) null)) : type == Double.TYPE ? Double.valueOf(field.getDouble((Object) null)) : type == Short.TYPE ? Short.valueOf(field.getShort((Object) null)) : type == Character.TYPE ? Character.valueOf(field.getChar((Object) null)) : type == Boolean.TYPE ? Boolean.valueOf(field.getBoolean((Object) null)) : type == Byte.TYPE ? Byte.valueOf(field.getByte((Object) null)) : field.get((Object) null);
        } catch (Exception e) {
            Log.e("Utils", e.toString());
            return null;
        }
    }

    public static native Object rL(Object[] objArr);

    public static void showRiskMessage(Context context, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Toast.makeText(context, str, 0).show();
            return;
        }
        Looper.prepare();
        Toast.makeText(context, str, 0).show();
        Looper.loop();
    }
}
