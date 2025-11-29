package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class CleanerJava9 implements Cleaner {
    /* access modifiers changed from: private */
    public static final Method INVOKE_CLEANER;
    private static final InternalLogger logger;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    static {
        /*
            java.lang.Class<io.netty.util.internal.CleanerJava9> r0 = io.netty.util.internal.CleanerJava9.class
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r0)
            logger = r0
            boolean r1 = io.netty.util.internal.PlatformDependent0.hasUnsafe()
            r2 = 0
            if (r1 == 0) goto L_0x0027
            r1 = 1
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            io.netty.util.internal.CleanerJava9$1 r3 = new io.netty.util.internal.CleanerJava9$1
            r3.<init>(r1)
            java.lang.Object r1 = java.security.AccessController.doPrivileged(r3)
            boolean r3 = r1 instanceof java.lang.Throwable
            if (r3 == 0) goto L_0x0024
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            goto L_0x002e
        L_0x0024:
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            goto L_0x0031
        L_0x0027:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r3 = "sun.misc.Unsafe unavailable"
            r1.<init>(r3)
        L_0x002e:
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0031:
            if (r2 != 0) goto L_0x0039
            java.lang.String r2 = "java.nio.ByteBuffer.cleaner(): available"
            r0.debug((java.lang.String) r2)
            goto L_0x003e
        L_0x0039:
            java.lang.String r3 = "java.nio.ByteBuffer.cleaner(): unavailable"
            r0.debug((java.lang.String) r3, (java.lang.Throwable) r2)
        L_0x003e:
            INVOKE_CLEANER = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.CleanerJava9.<clinit>():void");
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Exception exc = (Exception) AccessController.doPrivileged(new PrivilegedAction<Exception>() {
            public Exception run() {
                try {
                    CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, new Object[]{byteBuffer});
                    return null;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    return e;
                }
            }
        });
        if (exc != null) {
            PlatformDependent0.throwException(exc);
        }
    }

    public static boolean isSupported() {
        return INVOKE_CLEANER != null;
    }

    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (System.getSecurityManager() == null) {
            try {
                INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, new Object[]{byteBuffer});
            } catch (Throwable th) {
                PlatformDependent0.throwException(th);
            }
        } else {
            freeDirectBufferPrivileged(byteBuffer);
        }
    }
}
