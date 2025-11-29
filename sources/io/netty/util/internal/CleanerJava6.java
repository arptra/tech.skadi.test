package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class CleanerJava6 implements Cleaner {
    private static final Field CLEANER_FIELD;
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CleanerJava6.class);

    static {
        Method method;
        Field field;
        long j;
        Object obj;
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1);
        long j2 = -1;
        Throwable th = null;
        try {
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() {
                public Object run() {
                    try {
                        Field declaredField = allocateDirect.getClass().getDeclaredField("cleaner");
                        if (PlatformDependent.hasUnsafe()) {
                            return declaredField;
                        }
                        declaredField.setAccessible(true);
                        return declaredField;
                    } catch (Throwable th) {
                        return th;
                    }
                }
            });
            if (!(doPrivileged instanceof Throwable)) {
                field = (Field) doPrivileged;
                if (PlatformDependent.hasUnsafe()) {
                    j = PlatformDependent0.objectFieldOffset(field);
                    obj = PlatformDependent0.getObject(allocateDirect, j);
                } else {
                    obj = field.get(allocateDirect);
                    j = -1;
                }
                method = obj.getClass().getDeclaredMethod("clean", (Class[]) null);
                method.invoke(obj, (Object[]) null);
                j2 = j;
                if (th == null) {
                    logger.debug("java.nio.ByteBuffer.cleaner(): available");
                } else {
                    logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", th);
                }
                CLEANER_FIELD = field;
                CLEANER_FIELD_OFFSET = j2;
                CLEAN_METHOD = method;
                return;
            }
            throw ((Throwable) doPrivileged);
        } catch (Throwable th2) {
            field = null;
            method = null;
            th = th2;
        }
    }

    /* access modifiers changed from: private */
    public static void freeDirectBuffer0(ByteBuffer byteBuffer) throws Exception {
        long j = CLEANER_FIELD_OFFSET;
        Object object = j == -1 ? CLEANER_FIELD.get(byteBuffer) : PlatformDependent0.getObject(byteBuffer, j);
        if (object != null) {
            CLEAN_METHOD.invoke(object, (Object[]) null);
        }
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Throwable th = (Throwable) AccessController.doPrivileged(new PrivilegedAction<Throwable>() {
            public Throwable run() {
                try {
                    CleanerJava6.freeDirectBuffer0(byteBuffer);
                    return null;
                } catch (Throwable th) {
                    return th;
                }
            }
        });
        if (th != null) {
            PlatformDependent0.throwException(th);
        }
    }

    public static boolean isSupported() {
        return (CLEANER_FIELD_OFFSET == -1 && CLEANER_FIELD == null) ? false : true;
    }

    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            if (System.getSecurityManager() == null) {
                try {
                    freeDirectBuffer0(byteBuffer);
                } catch (Throwable th) {
                    PlatformDependent0.throwException(th);
                }
            } else {
                freeDirectBufferPrivileged(byteBuffer);
            }
        }
    }
}
