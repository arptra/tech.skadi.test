package org.apache.tika.utils;

import com.honey.account.oc.d;
import java.util.List;

public class ServiceLoaderUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        throw new java.lang.RuntimeException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0013 A[ExcHandler: IllegalAccessException | InstantiationException (r1v3 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:6:0x0016] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Class r1, org.apache.tika.config.ServiceLoader r2) {
        /*
            java.lang.Class<org.apache.tika.config.ServiceLoader> r0 = org.apache.tika.config.ServiceLoader.class
            java.lang.Class[] r0 = new java.lang.Class[]{r0}     // Catch:{ NoSuchMethodException -> 0x001c, InvocationTargetException -> 0x0015 }
            java.lang.reflect.Constructor r0 = r1.getDeclaredConstructor(r0)     // Catch:{ NoSuchMethodException -> 0x001c, InvocationTargetException -> 0x0015 }
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch:{ NoSuchMethodException -> 0x001c, InvocationTargetException -> 0x0015 }
            java.lang.Object r1 = r0.newInstance(r2)     // Catch:{ NoSuchMethodException -> 0x001c, InvocationTargetException -> 0x0015 }
            return r1
        L_0x0013:
            r1 = move-exception
            goto L_0x0021
        L_0x0015:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ IllegalAccessException | InstantiationException -> 0x0013, IllegalAccessException | InstantiationException -> 0x0013 }
            r2.<init>(r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x0013, IllegalAccessException | InstantiationException -> 0x0013 }
            throw r2     // Catch:{ IllegalAccessException | InstantiationException -> 0x0013, IllegalAccessException | InstantiationException -> 0x0013 }
        L_0x001c:
            java.lang.Object r1 = r1.newInstance()     // Catch:{ IllegalAccessException | InstantiationException -> 0x0013, IllegalAccessException | InstantiationException -> 0x0013 }
            return r1
        L_0x0021:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.utils.ServiceLoaderUtils.a(java.lang.Class, org.apache.tika.config.ServiceLoader):java.lang.Object");
    }

    public static void b(List list) {
        list.sort(new d());
    }
}
