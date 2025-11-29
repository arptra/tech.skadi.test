package com.meizu.flyme.policy.sdk.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SysProp {
    private static Method sysPropGet;
    private static Method sysPropSet;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("get")) {
                    sysPropGet = method;
                } else if (name.equals("set")) {
                    sysPropSet = method;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private SysProp() {
    }

    public static String get(String str, String str2) {
        try {
            return (String) sysPropGet.invoke((Object) null, new Object[]{str, str2});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static void set(String str, String str2) {
        try {
            sysPropSet.invoke((Object) null, new Object[]{str, str2});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
