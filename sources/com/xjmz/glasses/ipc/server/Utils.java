package com.xjmz.glasses.ipc.server;

public class Utils {
    public static int a(String str, int i) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke((Object) null, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (Exception unused) {
            return i;
        }
    }
}
