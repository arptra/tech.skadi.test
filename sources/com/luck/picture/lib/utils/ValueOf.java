package com.luck.picture.lib.utils;

public class ValueOf {
    public static double a(Object obj) {
        return b(obj, 0);
    }

    public static double b(Object obj, int i) {
        if (obj == null) {
            return (double) i;
        }
        try {
            return Double.parseDouble(obj.toString().trim());
        } catch (Exception unused) {
            return (double) i;
        }
    }

    public static int c(Object obj) {
        return d(obj, 0);
    }

    public static int d(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        try {
            String trim = obj.toString().trim();
            return trim.contains(".") ? Integer.parseInt(trim.substring(0, trim.lastIndexOf("."))) : Integer.parseInt(trim);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long e(Object obj) {
        return f(obj, 0);
    }

    public static long f(Object obj, long j) {
        if (obj == null) {
            return j;
        }
        try {
            String trim = obj.toString().trim();
            return trim.contains(".") ? Long.parseLong(trim.substring(0, trim.lastIndexOf("."))) : Long.parseLong(trim);
        } catch (Exception unused) {
            return j;
        }
    }

    public static String g(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
