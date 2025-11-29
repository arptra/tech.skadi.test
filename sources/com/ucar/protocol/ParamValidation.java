package com.ucar.protocol;

import java.util.Arrays;
import java.util.Objects;

public class ParamValidation {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) e(new NullPointerException(str + " must not be null")));
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            g(str);
        }
    }

    public static String d(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static Throwable e(Throwable th) {
        return f(th, ParamValidation.class.getName());
    }

    public static Throwable f(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return th;
    }

    public static void g(String str) {
        throw ((NullPointerException) e(new NullPointerException(d(str))));
    }
}
