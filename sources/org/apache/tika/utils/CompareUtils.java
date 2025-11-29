package org.apache.tika.utils;

public class CompareUtils {
    public static int a(Object obj, Object obj2) {
        String name = obj.getClass().getName();
        String name2 = obj2.getClass().getName();
        boolean startsWith = name.startsWith("org.apache.tika.");
        return startsWith == name2.startsWith("org.apache.tika.") ? name.compareTo(name2) : startsWith ? 1 : -1;
    }
}
