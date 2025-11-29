package org.slf4j.helpers;

import java.io.PrintStream;
import org.apache.commons.lang3.BooleanUtils;

public final class Util {

    /* renamed from: a  reason: collision with root package name */
    public static ClassContextSecurityManager f3467a = null;
    public static boolean b = false;

    public static final class ClassContextSecurityManager extends SecurityManager {
        public ClassContextSecurityManager() {
        }

        public Class[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static Class a() {
        int i;
        ClassContextSecurityManager b2 = b();
        if (b2 == null) {
            return null;
        }
        Class[] classContext = b2.getClassContext();
        String name = Util.class.getName();
        int i2 = 0;
        while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
            i2++;
        }
        if (i2 < classContext.length && (i = i2 + 2) < classContext.length) {
            return classContext[i];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    public static ClassContextSecurityManager b() {
        ClassContextSecurityManager classContextSecurityManager = f3467a;
        if (classContextSecurityManager != null) {
            return classContextSecurityManager;
        }
        if (b) {
            return null;
        }
        ClassContextSecurityManager e = e();
        f3467a = e;
        b = true;
        return e;
    }

    public static final void c(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    public static final void d(String str, Throwable th) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Reported exception:");
        th.printStackTrace();
    }

    public static ClassContextSecurityManager e() {
        try {
            return new ClassContextSecurityManager();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean f(String str) {
        String g = g(str);
        if (g == null) {
            return false;
        }
        return g.equalsIgnoreCase(BooleanUtils.TRUE);
    }

    public static String g(String str) {
        if (str != null) {
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("null input");
        }
    }
}
