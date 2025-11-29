package dev.fluttercommunity.plus.device_info;

import android.app.ActivityManager;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.starrynet.common.StarryNetConstant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0017¨\u0006\u0019"}, d2 = {"Ldev/fluttercommunity/plus/device_info/MethodCallHandlerImpl;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Landroid/content/pm/PackageManager;", "packageManager", "Landroid/app/ActivityManager;", "activityManager", "<init>", "(Landroid/content/pm/PackageManager;Landroid/app/ActivityManager;)V", "Lio/flutter/plugin/common/MethodCall;", "call", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "", "", "a", "()Ljava/util/List;", "Landroid/content/pm/PackageManager;", "b", "Landroid/app/ActivityManager;", "", "()Z", "isEmulator", "device_info_plus_release"}, k = 1, mv = {1, 7, 1})
public final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public final PackageManager f8793a;
    public final ActivityManager b;

    public MethodCallHandlerImpl(PackageManager packageManager, ActivityManager activityManager) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(activityManager, "activityManager");
        this.f8793a = packageManager;
        this.b = activityManager;
    }

    public final List a() {
        FeatureInfo[] systemAvailableFeatures = this.f8793a.getSystemAvailableFeatures();
        Intrinsics.checkNotNullExpressionValue(systemAvailableFeatures, "packageManager.systemAvailableFeatures");
        ArrayList<FeatureInfo> arrayList = new ArrayList<>();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo.name != null) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (FeatureInfo featureInfo2 : arrayList) {
            arrayList2.add(featureInfo2.name);
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        if (kotlin.text.StringsKt.startsWith$default(r5, "generic", false, 2, (java.lang.Object) null) == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b() {
        /*
            r5 = this;
            java.lang.String r5 = android.os.Build.BRAND
            java.lang.String r0 = "BRAND"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "generic"
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r0, r1, r2, r3)
            if (r5 == 0) goto L_0x001f
            java.lang.String r5 = android.os.Build.DEVICE
            java.lang.String r4 = "DEVICE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r0, r1, r2, r3)
            if (r5 != 0) goto L_0x00b7
        L_0x001f:
            java.lang.String r5 = android.os.Build.FINGERPRINT
            java.lang.String r4 = "FINGERPRINT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r5, r0, r1, r2, r3)
            if (r0 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            java.lang.String r0 = "unknown"
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r0, r1, r2, r3)
            if (r5 != 0) goto L_0x00b7
            java.lang.String r5 = android.os.Build.HARDWARE
            java.lang.String r0 = "HARDWARE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r4 = "goldfish"
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r4, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "ranchu"
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r5 != 0) goto L_0x00b7
            java.lang.String r5 = android.os.Build.MODEL
            java.lang.String r0 = "MODEL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r4 = "google_sdk"
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r4, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r4 = "Emulator"
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r4, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "Android SDK built for x86"
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r5 != 0) goto L_0x00b7
            java.lang.String r5 = android.os.Build.MANUFACTURER
            java.lang.String r0 = "MANUFACTURER"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "Genymotion"
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r5 != 0) goto L_0x00b7
            java.lang.String r5 = android.os.Build.PRODUCT
            java.lang.String r0 = "PRODUCT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r4 = "sdk"
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r4, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r4 = "vbox86p"
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r4, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r4 = "emulator"
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r4, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "simulator"
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r5 == 0) goto L_0x00b8
        L_0x00b7:
            r1 = 1
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.fluttercommunity.plus.device_info.MethodCallHandlerImpl.b():boolean");
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (methodCall.method.equals("getDeviceInfo")) {
            HashMap hashMap = new HashMap();
            String str2 = Build.BOARD;
            Intrinsics.checkNotNullExpressionValue(str2, "BOARD");
            hashMap.put("board", str2);
            String str3 = Build.BOOTLOADER;
            Intrinsics.checkNotNullExpressionValue(str3, "BOOTLOADER");
            hashMap.put("bootloader", str3);
            String str4 = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(str4, "BRAND");
            hashMap.put("brand", str4);
            String str5 = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(str5, "DEVICE");
            hashMap.put("device", str5);
            String str6 = Build.DISPLAY;
            Intrinsics.checkNotNullExpressionValue(str6, "DISPLAY");
            hashMap.put("display", str6);
            String str7 = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(str7, "FINGERPRINT");
            hashMap.put("fingerprint", str7);
            String str8 = Build.HARDWARE;
            Intrinsics.checkNotNullExpressionValue(str8, "HARDWARE");
            hashMap.put("hardware", str8);
            String str9 = Build.HOST;
            Intrinsics.checkNotNullExpressionValue(str9, "HOST");
            hashMap.put(ApiConstant.VALUE_HOST, str9);
            String str10 = Build.ID;
            Intrinsics.checkNotNullExpressionValue(str10, "ID");
            hashMap.put("id", str10);
            String str11 = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(str11, "MANUFACTURER");
            hashMap.put("manufacturer", str11);
            String str12 = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(str12, "MODEL");
            hashMap.put("model", str12);
            String str13 = Build.PRODUCT;
            Intrinsics.checkNotNullExpressionValue(str13, "PRODUCT");
            hashMap.put("product", str13);
            int i = Build.VERSION.SDK_INT;
            String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
            Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_32_BIT_ABIS");
            hashMap.put("supported32BitAbis", CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)));
            String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
            Intrinsics.checkNotNullExpressionValue(strArr2, "SUPPORTED_64_BIT_ABIS");
            hashMap.put("supported64BitAbis", CollectionsKt.listOf(Arrays.copyOf(strArr2, strArr2.length)));
            String[] strArr3 = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(strArr3, "SUPPORTED_ABIS");
            hashMap.put("supportedAbis", CollectionsKt.listOf(Arrays.copyOf(strArr3, strArr3.length)));
            String str14 = Build.TAGS;
            Intrinsics.checkNotNullExpressionValue(str14, "TAGS");
            hashMap.put("tags", str14);
            String str15 = Build.TYPE;
            Intrinsics.checkNotNullExpressionValue(str15, "TYPE");
            hashMap.put("type", str15);
            hashMap.put("isPhysicalDevice", Boolean.valueOf(!b()));
            hashMap.put("systemFeatures", a());
            HashMap hashMap2 = new HashMap();
            String str16 = Build.VERSION.BASE_OS;
            Intrinsics.checkNotNullExpressionValue(str16, "BASE_OS");
            hashMap2.put("baseOS", str16);
            hashMap2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
            String str17 = Build.VERSION.SECURITY_PATCH;
            Intrinsics.checkNotNullExpressionValue(str17, "SECURITY_PATCH");
            hashMap2.put("securityPatch", str17);
            String str18 = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(str18, "CODENAME");
            hashMap2.put("codename", str18);
            String str19 = Build.VERSION.INCREMENTAL;
            Intrinsics.checkNotNullExpressionValue(str19, "INCREMENTAL");
            hashMap2.put("incremental", str19);
            String str20 = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(str20, "RELEASE");
            hashMap2.put("release", str20);
            hashMap2.put("sdkInt", Integer.valueOf(i));
            hashMap.put("version", hashMap2);
            hashMap.put("isLowRamDevice", Boolean.valueOf(this.b.isLowRamDevice()));
            try {
                str = Build.getSerial();
            } catch (SecurityException unused) {
                str = StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n                  …UNKNOWN\n                }");
            hashMap.put("serialNumber", str);
            result.success(hashMap);
            return;
        }
        result.notImplemented();
    }
}
