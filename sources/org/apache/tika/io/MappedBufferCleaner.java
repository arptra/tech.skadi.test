package org.apache.tika.io;

import com.honey.account.ic.a;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.Objects;

public class MappedBufferCleaner {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9657a;
    public static final String b;
    public static final BufferCleaner c;

    public interface BufferCleaner {
    }

    static {
        Object doPrivileged = AccessController.doPrivileged(new a());
        if (doPrivileged instanceof BufferCleaner) {
            c = (BufferCleaner) doPrivileged;
            f9657a = true;
            b = null;
            return;
        }
        c = null;
        f9657a = false;
        b = doPrivileged.toString();
    }

    public static BufferCleaner b(Class cls, MethodHandle methodHandle) {
        return new a(cls, methodHandle);
    }

    public static Object c() {
        Class<ByteBuffer> cls = ByteBuffer.class;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            MethodHandle findVirtual = lookup.findVirtual(cls2, "invokeCleaner", MethodType.methodType(Void.TYPE, cls));
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return b(cls, findVirtual.bindTo(declaredField.get((Object) null)));
        } catch (SecurityException e) {
            throw e;
        } catch (ReflectiveOperationException | RuntimeException unused) {
            Class<?> cls3 = Class.forName("java.nio.DirectByteBuffer");
            Method method = cls3.getMethod("cleaner", (Class[]) null);
            method.setAccessible(true);
            MethodHandle unreflect = lookup.unreflect(method);
            Class<?> returnType = unreflect.type().returnType();
            Class cls4 = Void.TYPE;
            MethodHandle findVirtual2 = lookup.findVirtual(returnType, "clean", MethodType.methodType(cls4));
            Class cls5 = Boolean.TYPE;
            return b(cls3, MethodHandles.filterReturnValue(unreflect, MethodHandles.guardWithTest(lookup.findStatic(Objects.class, "nonNull", MethodType.methodType(cls5, Object.class)).asType(MethodType.methodType(cls5, returnType)), findVirtual2, MethodHandles.dropArguments(MethodHandles.constant(Void.class, (Object) null).asType(MethodType.methodType(cls4)), 0, new Class[]{returnType}))).asType(MethodType.methodType(cls4, cls)));
        } catch (SecurityException e2) {
            return "Unmapping is not supported, because not all required permissions are given to  the Tika JAR file: " + e2 + " [Please grant at least the following permissions:  RuntimePermission(\"accessClassInPackage.sun.misc\")  and ReflectPermission(\"suppressAccessChecks\")]";
        } catch (ReflectiveOperationException | RuntimeException e3) {
            return "Unmapping is not supported on this platform, because internal Java APIs are not compatible with this Lucene version: " + e3;
        }
    }
}
