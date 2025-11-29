package com.upuphone.starryiccoaproto;

import java.util.Arrays;
import java.util.Objects;

public class ParamValidation {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) c(new NullPointerException(str + " must not be null")));
        }
    }

    public static Throwable c(Throwable th) {
        return d(th, ParamValidation.class.getName());
    }

    public static Throwable d(Throwable th, String str) {
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
}
