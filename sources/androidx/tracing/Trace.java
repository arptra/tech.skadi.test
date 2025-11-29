package androidx.tracing;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {

    /* renamed from: a  reason: collision with root package name */
    public static long f1823a;
    public static Method b;
    public static Method c;
    public static Method d;

    public static void a(String str, int i) {
        try {
            if (c == null) {
                TraceApi29Impl.a(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i);
    }

    public static void b(String str, int i) {
        try {
            if (c == null) {
                c = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            c.invoke((Object) null, new Object[]{Long.valueOf(f1823a), str, Integer.valueOf(i)});
        } catch (Exception e) {
            g("asyncTraceBegin", e);
        }
    }

    public static void c(String str) {
        TraceApi18Impl.a(str);
    }

    public static void d(String str, int i) {
        try {
            if (d == null) {
                TraceApi29Impl.b(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i);
    }

    public static void e(String str, int i) {
        try {
            if (d == null) {
                d = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            d.invoke((Object) null, new Object[]{Long.valueOf(f1823a), str, Integer.valueOf(i)});
        } catch (Exception e) {
            g("asyncTraceEnd", e);
        }
    }

    public static void f() {
        TraceApi18Impl.b();
    }

    public static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        try {
            if (b == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    public static boolean i() {
        Class<android.os.Trace> cls = android.os.Trace.class;
        try {
            if (b == null) {
                f1823a = cls.getField("TRACE_TAG_APP").getLong((Object) null);
                b = cls.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) b.invoke((Object) null, new Object[]{Long.valueOf(f1823a)})).booleanValue();
        } catch (Exception e) {
            g("isTagEnabled", e);
            return false;
        }
    }
}
