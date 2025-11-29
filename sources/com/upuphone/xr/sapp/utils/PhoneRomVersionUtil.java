package com.upuphone.xr.sapp.utils;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/utils/PhoneRomVersionUtil;", "", "<init>", "()V", "", "phoneBrand", "b", "(Ljava/lang/String;)Ljava/lang/String;", "str", "a", "key", "c", "", "e", "(Ljava/lang/String;)V", "Ljava/lang/String;", "customOS", "customOSVersion", "", "d", "()Z", "isHarmonyOS", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneRomVersionUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final PhoneRomVersionUtil f7911a = new PhoneRomVersionUtil();
    public static String b = "";
    public static String c = "";

    public final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (StringsKt.isBlank(str)) {
            return "";
        }
        String replace = new Regex(" ").replace((CharSequence) str, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = replace.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "phoneBrand");
        String str2 = b;
        if (str2 == null || StringsKt.isBlank(str2)) {
            e(str);
        }
        String str3 = b;
        String str4 = c;
        return str3 + str4;
    }

    public final String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            return (String) invoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean d() {
        boolean z = false;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            String str = (String) cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null);
            if (str == null || StringsKt.isBlank(str)) {
                z = true;
            }
            return !z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
        b = "MIUI";
        c = c("ro.miui.ui.version.name");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011d, code lost:
        if (r8.equals("REALME") == false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0128, code lost:
        b = "ColorOS";
        c = c("ro.build.version.opporom");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0134, code lost:
        r7 = c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0136, code lost:
        if (r7 == null) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0138, code lost:
        r8 = b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x013a, code lost:
        if (r8 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013c, code lost:
        r8 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x013d, code lost:
        r7 = kotlin.text.StringsKt.replace(r7, r8, "", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0143, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0144, code lost:
        c = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ro.build.version.magic"
            java.lang.String r8 = r7.a(r8)     // Catch:{ Exception -> 0x0033 }
            int r1 = r8.hashCode()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r2 = "ro.build.version.emui"
            java.lang.String r3 = "EMUI"
            java.lang.String r4 = "HarmonyOS"
            java.lang.String r5 = ""
            java.lang.String r6 = "hw_sc.build.platform.version"
            switch(r1) {
                case -1881642058: goto L_0x0117;
                case -1706170181: goto L_0x0101;
                case -602397472: goto L_0x00eb;
                case 2432928: goto L_0x00e2;
                case 2634924: goto L_0x00cc;
                case 68924490: goto L_0x007e;
                case 73239724: goto L_0x0066;
                case 74632627: goto L_0x004a;
                case 77852109: goto L_0x0040;
                case 2141820391: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x011f
        L_0x0019:
            java.lang.String r0 = "HUAWEI"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x0023
            goto L_0x011f
        L_0x0023:
            boolean r8 = r7.d()     // Catch:{ Exception -> 0x0033 }
            if (r8 == 0) goto L_0x0036
            java.lang.String r7 = r7.c(r6)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            b = r4     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x0033:
            r7 = move-exception
            goto L_0x0147
        L_0x0036:
            b = r3     // Catch:{ Exception -> 0x0033 }
            java.lang.String r7 = r7.c(r2)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x0040:
            java.lang.String r0 = "REDMI"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x010a
            goto L_0x011f
        L_0x004a:
            java.lang.String r0 = "NUBIA"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x0054
            goto L_0x011f
        L_0x0054:
            java.lang.String r8 = "ro.build.nubia.rom.name"
            java.lang.String r8 = r7.c(r8)     // Catch:{ Exception -> 0x0033 }
            b = r8     // Catch:{ Exception -> 0x0033 }
            java.lang.String r8 = "ro.build.nubia.rom.code"
            java.lang.String r7 = r7.c(r8)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x0066:
            java.lang.String r0 = "MEIZU"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x0070
            goto L_0x011f
        L_0x0070:
            java.lang.String r8 = "Flyme"
            b = r8     // Catch:{ Exception -> 0x0033 }
            java.lang.String r8 = "ro.build.display.id"
            java.lang.String r7 = r7.c(r8)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x007e:
            java.lang.String r1 = "HONOR"
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x0088
            goto L_0x011f
        L_0x0088:
            boolean r8 = r7.d()     // Catch:{ Exception -> 0x0033 }
            if (r8 == 0) goto L_0x00a9
            b = r4     // Catch:{ Exception -> 0x0033 }
            java.lang.String r8 = r7.c(r6)     // Catch:{ Exception -> 0x0033 }
            if (r8 == 0) goto L_0x00a5
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)     // Catch:{ Exception -> 0x0033 }
            if (r8 == 0) goto L_0x009d
            goto L_0x00a5
        L_0x009d:
            java.lang.String r7 = r7.c(r6)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x00a5:
            c = r5     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x00a9:
            java.lang.String r8 = r7.c(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 == 0) goto L_0x00c0
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)     // Catch:{ Exception -> 0x0033 }
            if (r8 == 0) goto L_0x00b6
            goto L_0x00c0
        L_0x00b6:
            b = r3     // Catch:{ Exception -> 0x0033 }
            java.lang.String r7 = r7.c(r2)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x00c0:
            java.lang.String r8 = "MagicUI"
            b = r8     // Catch:{ Exception -> 0x0033 }
            java.lang.String r7 = r7.c(r0)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x00cc:
            java.lang.String r0 = "VIVO"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x00d5
            goto L_0x011f
        L_0x00d5:
            java.lang.String r8 = "Funtouch"
            b = r8     // Catch:{ Exception -> 0x0033 }
            java.lang.String r8 = "ro.vivo.os.version"
            java.lang.String r7 = r7.c(r8)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x00e2:
            java.lang.String r0 = "OPPO"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x0128
            goto L_0x011f
        L_0x00eb:
            java.lang.String r0 = "ONEPLUS"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x00f4
            goto L_0x011f
        L_0x00f4:
            java.lang.String r8 = "HydrogenOS"
            b = r8     // Catch:{ Exception -> 0x0033 }
            java.lang.String r8 = "ro.rom.version"
            java.lang.String r7 = r7.c(r8)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x0101:
            java.lang.String r0 = "XIAOMI"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x010a
            goto L_0x011f
        L_0x010a:
            java.lang.String r8 = "MIUI"
            b = r8     // Catch:{ Exception -> 0x0033 }
            java.lang.String r8 = "ro.miui.ui.version.name"
            java.lang.String r7 = r7.c(r8)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x0117:
            java.lang.String r0 = "REALME"
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x0128
        L_0x011f:
            java.lang.String r7 = "Android"
            b = r7     // Catch:{ Exception -> 0x0033 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0134
        L_0x0128:
            java.lang.String r8 = "ColorOS"
            b = r8     // Catch:{ Exception -> 0x0033 }
            java.lang.String r8 = "ro.build.version.opporom"
            java.lang.String r7 = r7.c(r8)     // Catch:{ Exception -> 0x0033 }
            c = r7     // Catch:{ Exception -> 0x0033 }
        L_0x0134:
            java.lang.String r7 = c     // Catch:{ Exception -> 0x0033 }
            if (r7 == 0) goto L_0x0143
            java.lang.String r8 = b     // Catch:{ Exception -> 0x0033 }
            if (r8 != 0) goto L_0x013d
            r8 = r5
        L_0x013d:
            r0 = 1
            java.lang.String r7 = kotlin.text.StringsKt.replace((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r5, (boolean) r0)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0144
        L_0x0143:
            r7 = 0
        L_0x0144:
            c = r7     // Catch:{ Exception -> 0x0033 }
            goto L_0x0150
        L_0x0147:
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "PhoneRomVersionUtil"
            java.lang.String r1 = "get rom version failed"
            r8.d(r0, r1, r7)
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.PhoneRomVersionUtil.e(java.lang.String):void");
    }
}
