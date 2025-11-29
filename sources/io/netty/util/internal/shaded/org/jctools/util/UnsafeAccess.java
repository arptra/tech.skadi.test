package io.netty.util.internal.shaded.org.jctools.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeAccess {
    public static final boolean SUPPORTS_GET_AND_ADD_LONG = hasGetAndAddLongSupport();
    public static final boolean SUPPORTS_GET_AND_SET_REF = hasGetAndSetSupport();
    public static final Unsafe UNSAFE = getUnsafe();

    public static long fieldOffset(Class cls, String str) throws RuntimeException {
        try {
            return UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private static Unsafe getUnsafe() {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return (Unsafe) declaredField.get((Object) null);
        } catch (Exception unused) {
            try {
                Constructor<Unsafe> declaredConstructor = Unsafe.class.getDeclaredConstructor((Class[]) null);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance((Object[]) null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static boolean hasGetAndAddLongSupport() {
        Class<Unsafe> cls = Unsafe.class;
        Class<Object> cls2 = Object.class;
        try {
            Class cls3 = Long.TYPE;
            cls.getMethod("getAndAddLong", new Class[]{cls2, cls3, cls3});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasGetAndSetSupport() {
        Class<Object> cls = Object.class;
        try {
            Unsafe.class.getMethod("getAndSetObject", new Class[]{cls, Long.TYPE, cls});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
