package com.xingin.xhssharesdk.a;

import com.meizu.common.widget.MzContactsContract;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f8122a = f();
    public static final boolean b = h();
    public static final boolean c = g();
    public static final long d = ((long) b());

    public static class a implements PrivilegedExceptionAction<Unsafe> {
        public static Unsafe a() {
            Class<Unsafe> cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get((Object) null);
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }

        public final /* bridge */ /* synthetic */ Object run() {
            return a();
        }
    }

    static {
        Field field;
        try {
            field = Buffer.class.getDeclaredField(MzContactsContract.MzContactColumns.ADDRESS);
            field.setAccessible(true);
        } catch (Throwable unused) {
            field = null;
        }
        c(field);
    }

    public static byte a(byte[] bArr, long j) {
        return f8122a.getByte(bArr, j);
    }

    public static int b() {
        if (c) {
            return f8122a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    public static void c(Field field) {
        Unsafe unsafe;
        if (field != null && (unsafe = f8122a) != null) {
            unsafe.objectFieldOffset(field);
        }
    }

    public static void d(byte[] bArr, long j, byte b2) {
        f8122a.putByte(bArr, j, b2);
    }

    public static long e(byte[] bArr, long j) {
        return f8122a.getLong(bArr, j);
    }

    public static Unsafe f() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f8122a;
        if (unsafe != null) {
            try {
                Class<?> cls2 = unsafe.getClass();
                cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls, cls3});
                cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
                cls2.getMethod("getLong", new Class[]{cls, cls3});
                cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean h() {
        Unsafe unsafe = f8122a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", new Class[]{cls2});
                cls.getMethod("getLong", new Class[]{Object.class, cls2});
                cls.getMethod("putByte", new Class[]{cls2, Byte.TYPE});
                cls.getMethod("getLong", new Class[]{cls2});
                cls.getMethod("copyMemory", new Class[]{cls2, cls2, cls2});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
