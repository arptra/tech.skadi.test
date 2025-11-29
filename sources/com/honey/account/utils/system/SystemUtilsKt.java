package com.honey.account.utils.system;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.honey.account.utils.log.LogUtils;
import com.ucar.vehiclesdk.MDevice;
import java.lang.reflect.Method;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010\t\u001a\u00020\u0001\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0006\u0010\u0011\u001a\u00020\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"TAG", "", "dp2px", "", "context", "Landroid/content/Context;", "dp", "", "getCurrentLanguage", "getLocalLanguage", "getOperator", "getProcessName", "getScreenResolution", "getSystemProperties", "name", "isHuawei", "", "isMeizu", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SystemUtilsKt {
    @NotNull
    private static final String TAG = "SystemUtils";

    public static final int dp2px(@NotNull Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    @Nullable
    public static final String getCurrentLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            LogUtils logUtils = LogUtils.INSTANCE;
            String str = TAG;
            logUtils.e(str, "getCurrentLanguage error " + e.getMessage());
            return null;
        }
    }

    @NotNull
    public static final String getLocalLanguage() {
        return Locale.getDefault().getLanguage() + '_' + Locale.getDefault().getCountry();
    }

    @Nullable
    public static final String getOperator(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            return ((TelephonyManager) systemService).getSimOperator();
        } catch (Exception e) {
            LogUtils logUtils = LogUtils.INSTANCE;
            String str = TAG;
            logUtils.e(str, "getOperator error " + e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd A[SYNTHETIC, Splitter:B:32:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cc A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d1 A[SYNTHETIC, Splitter:B:39:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getProcessName(@org.jetbrains.annotations.NotNull android.content.Context r6) {
        /*
            java.lang.String r0 = "getProcessName error "
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "activity"
            java.lang.Object r6 = r6.getSystemService(r1)
            java.lang.String r1 = "null cannot be cast to non-null type android.app.ActivityManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            android.app.ActivityManager r6 = (android.app.ActivityManager) r6
            int r1 = android.os.Process.myPid()
            java.util.List r2 = r6.getRunningAppProcesses()
            r3 = 0
            if (r2 == 0) goto L_0x003a
            java.util.List r6 = r6.getRunningAppProcesses()
            java.util.Iterator r6 = r6.iterator()
        L_0x0027:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x003a
            java.lang.Object r2 = r6.next()
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2
            int r4 = r2.pid
            if (r4 != r1) goto L_0x0027
            java.lang.String r6 = r2.processName
            goto L_0x003b
        L_0x003a:
            r6 = r3
        L_0x003b:
            if (r6 == 0) goto L_0x0043
            int r2 = r6.length()
            if (r2 != 0) goto L_0x00ca
        L_0x0043:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00a2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2 }
            r4.<init>()     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ Exception -> 0x00a2 }
            r4.append(r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r1 = "/cmdline"
            r4.append(r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00a2 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00a2 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a2 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00a2 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a2 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x00a2 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00a2 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r6 = r1.readLine()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            if (r6 == 0) goto L_0x0082
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r6)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            goto L_0x0082
        L_0x007c:
            r6 = move-exception
            r3 = r1
            goto L_0x00cf
        L_0x007f:
            r2 = move-exception
            r3 = r1
            goto L_0x00a3
        L_0x0082:
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x00ca
        L_0x0086:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x008e:
            r3.append(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r2, r0)
            goto L_0x00ca
        L_0x00a0:
            r6 = move-exception
            goto L_0x00cf
        L_0x00a2:
            r2 = move-exception
        L_0x00a3:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r4.<init>()     // Catch:{ all -> 0x00a0 }
            r4.append(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00a0 }
            r4.append(r2)     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00a0 }
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x00a0 }
            if (r3 == 0) goto L_0x00ca
            r3.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00ca
        L_0x00c1:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x008e
        L_0x00ca:
            if (r6 != 0) goto L_0x00ce
            java.lang.String r6 = ""
        L_0x00ce:
            return r6
        L_0x00cf:
            if (r3 == 0) goto L_0x00ee
            r3.close()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00ee
        L_0x00d5:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r2, r0)
        L_0x00ee:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.utils.system.SystemUtilsKt.getProcessName(android.content.Context):java.lang.String");
    }

    @NotNull
    public static final String getScreenResolution(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Point point = new Point();
        Display display = null;
        try {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            display = ((WindowManager) systemService).getDefaultDisplay();
            display.getSize(point);
        } catch (Exception unused) {
            LogUtils logUtils = LogUtils.INSTANCE;
            String str = TAG;
            logUtils.e(str, "Display.getSize isn't available on older devices.");
            if (display != null) {
                point.x = display.getWidth();
                point.y = display.getHeight();
            } else {
                logUtils.e(str, "error get display");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(point.x);
        sb.append('.');
        sb.append(point.y);
        return sb.toString();
    }

    @Nullable
    public static final String getSystemProperties(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[]{str});
            if (invoke != null) {
                return invoke.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils logUtils = LogUtils.INSTANCE;
            String str2 = TAG;
            logUtils.e(str2, "get system properties error, " + e.getMessage());
        }
        return null;
    }

    public static final boolean isHuawei() {
        String systemProperties = getSystemProperties("ro.build.version.emui");
        if (systemProperties != null && systemProperties.length() != 0) {
            return true;
        }
        String str = Build.MANUFACTURER;
        return StringsKt.equals("huawei", str, true) || StringsKt.equals("honor", str, true) || StringsKt.equals("oce", str, true);
    }

    public static final boolean isMeizu() {
        String str = Build.BRAND;
        return StringsKt.equals(MDevice.MANUFACTURERS_MEIZU, str, true) || StringsKt.equals("mblu", str, true) || !TextUtils.isEmpty(getSystemProperties("ro.vendor.meizu.product.model")) || !TextUtils.isEmpty(getSystemProperties("ro.meizu.product.model"));
    }
}
