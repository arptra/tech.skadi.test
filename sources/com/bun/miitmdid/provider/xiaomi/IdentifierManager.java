package com.bun.miitmdid.provider.xiaomi;

import android.content.Context;
import com.netease.nis.sdkwrapper.Utils;
import java.lang.reflect.Method;

public class IdentifierManager {
    private static final String TAG = "IdentifierManager";
    private static Class<?> sClass;
    private static Method sGetAAID;
    private static Method sGetOAID;
    private static Method sGetVAID;
    private static Object sIdProivderImpl;

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|(3:6|7|8)|9|10|(3:12|13|14)|15|16|(4:18|19|20|22)(1:24)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0014  */
    static {
        /*
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            java.lang.String r1 = "com.android.id.impl.IdProviderImpl"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0010 }
            sClass = r1     // Catch:{ Exception -> 0x0010 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ Exception -> 0x0010 }
            sIdProivderImpl = r1     // Catch:{ Exception -> 0x0010 }
        L_0x0010:
            java.lang.Class<?> r1 = sClass     // Catch:{ Exception -> 0x0020 }
            if (r1 == 0) goto L_0x0020
            java.lang.String r2 = "getOAID"
            java.lang.Class[] r3 = new java.lang.Class[]{r0}     // Catch:{ Exception -> 0x0020 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x0020 }
            sGetOAID = r1     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            java.lang.Class<?> r1 = sClass     // Catch:{ Exception -> 0x0030 }
            if (r1 == 0) goto L_0x0030
            java.lang.String r2 = "getVAID"
            java.lang.Class[] r3 = new java.lang.Class[]{r0}     // Catch:{ Exception -> 0x0030 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x0030 }
            sGetVAID = r1     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            java.lang.Class<?> r1 = sClass     // Catch:{ Exception -> 0x0040 }
            if (r1 == 0) goto L_0x0040
            java.lang.String r2 = "getAAID"
            java.lang.Class[] r0 = new java.lang.Class[]{r0}     // Catch:{ Exception -> 0x0040 }
            java.lang.reflect.Method r0 = r1.getMethod(r2, r0)     // Catch:{ Exception -> 0x0040 }
            sGetAAID = r0     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bun.miitmdid.provider.xiaomi.IdentifierManager.<clinit>():void");
    }

    public static String getAAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 98;
        objArr[3] = 1606976968570L;
        return (String) Utils.rL(objArr);
    }

    public static String getOAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 99;
        objArr[3] = 1606976968571L;
        return (String) Utils.rL(objArr);
    }

    public static String getUDID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 100;
        objArr[3] = 1606976968572L;
        return (String) Utils.rL(objArr);
    }

    public static String getVAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 101;
        objArr[3] = 1606976968573L;
        return (String) Utils.rL(objArr);
    }

    private static String invokeMethod(Context context, Method method) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = method;
        objArr[3] = 102;
        objArr[4] = 1606976968574L;
        return (String) Utils.rL(objArr);
    }

    public static boolean isSupported() {
        Object[] objArr = new Object[3];
        objArr[1] = 103;
        objArr[2] = 1606976968575L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }
}
