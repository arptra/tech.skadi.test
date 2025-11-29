package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.FileProvider;
import androidx.preference.PreferenceManager;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0015J3\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010 \u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\"2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b'\u0010\u0017J\u0015\u0010)\u001a\u00020(2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u0017J\u000f\u0010,\u001a\u00020\bH\u0007¢\u0006\u0004\b,\u0010-R\u0011\u00100\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AppUtils;", "", "<init>", "()V", "", "s", "Landroid/content/Context;", "context", "", "h", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "file", "Landroid/net/Uri;", "f", "(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;", "Landroid/app/Activity;", "activity", "", "requestCode", "p", "(Landroid/app/Activity;I)V", "r", "(Landroid/content/Context;)V", "k", "m", "", "packages", "uri", "modeFlags", "i", "(Landroid/content/Context;[Ljava/lang/String;Landroid/net/Uri;I)V", "d", "(Ljava/io/File;[Ljava/lang/String;)Landroid/net/Uri;", "Lkotlin/Pair;", "g", "(Landroid/content/Context;)Lkotlin/Pair;", "o", "(Landroid/content/Context;Landroid/net/Uri;)V", "a", "", "c", "(Ljava/io/File;)Z", "b", "e", "()Ljava/lang/String;", "j", "()Z", "isHuawei", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAppUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppUtils.kt\ncom/upuphone/xr/sapp/utils/AppUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,257:1\n13309#2,2:258\n*S KotlinDebug\n*F\n+ 1 AppUtils.kt\ncom/upuphone/xr/sapp/utils/AppUtils\n*L\n164#1:258,2\n*E\n"})
public final class AppUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AppUtils f7842a = new AppUtils();

    public static /* synthetic */ void l(AppUtils appUtils, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        appUtils.k(activity, i);
    }

    public static /* synthetic */ void n(AppUtils appUtils, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        appUtils.m(activity, i);
    }

    public static /* synthetic */ void q(AppUtils appUtils, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        appUtils.p(activity, i);
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String packageName = context.getPackageName();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("AppUtils", "clearAppData packageName: " + packageName);
            String path = context.getFilesDir().getPath();
            String path2 = context.getCacheDir().getPath();
            File externalFilesDir = context.getExternalFilesDir((String) null);
            Intrinsics.checkNotNull(externalFilesDir);
            String path3 = externalFilesDir.getPath();
            File externalCacheDir = context.getExternalCacheDir();
            Intrinsics.checkNotNull(externalCacheDir);
            String[] strArr = {path, path2, path3, externalCacheDir.getPath()};
            for (int i = 0; i < 4; i++) {
                c(new File(strArr[i], packageName));
            }
            SharedPreferences b = PreferenceManager.b(context);
            Intrinsics.checkNotNullExpressionValue(b, "getDefaultSharedPreferences(...)");
            b.edit().clear().commit();
            context.deleteSharedPreferences(packageName);
        } catch (Exception e) {
            e.printStackTrace();
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("AppUtils", "deleteRecursive eh:" + e);
        }
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).clearApplicationUserData();
    }

    public final boolean c(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        ULog.f6446a.c("AppUtils", "deleteRecursively deleteRecursively.path:" + file.getPath());
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles(...)");
            for (File file2 : listFiles) {
                Intrinsics.checkNotNull(file2);
                c(file2);
            }
        }
        return file.delete();
    }

    public final Uri d(File file, String[] strArr) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(strArr, "packages");
        Uri f = f(GlobalExtKt.f(), file);
        f7842a.i(GlobalExtKt.f(), strArr, f, 1);
        return f;
    }

    public final String e() {
        String string = Settings.Secure.getString(GlobalExtKt.f().getContentResolver(), "android_id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final Uri f(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        String packageName = context.getPackageName();
        Uri uriForFile = FileProvider.getUriForFile(context, packageName + ".files", file);
        Intrinsics.checkNotNull(uriForFile);
        return uriForFile;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r0 = kotlin.TuplesKt.to(r0.getLanguage(), r0.getCountry());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair g(android.content.Context r1) {
        /*
            r0 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            android.content.res.Resources r0 = r1.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            android.os.LocaleList r0 = r0.getLocales()
            r1 = 0
            java.util.Locale r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0026
            java.lang.String r1 = r0.getLanguage()
            java.lang.String r0 = r0.getCountry()
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)
            if (r0 != 0) goto L_0x002f
        L_0x0026:
            java.lang.String r0 = "zh"
            java.lang.String r1 = "CN"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.AppUtils.g(android.content.Context):kotlin.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(android.content.Context r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.upuphone.xr.sapp.utils.AppUtils$getStarryNetVersionName$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.xr.sapp.utils.AppUtils$getStarryNetVersionName$1 r0 = (com.upuphone.xr.sapp.utils.AppUtils$getStarryNetVersionName$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.utils.AppUtils$getStarryNetVersionName$1 r0 = new com.upuphone.xr.sapp.utils.AppUtils$getStarryNetVersionName$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.utils.AppUtils$getStarryNetVersionName$2 r1 = new com.upuphone.xr.sapp.utils.AppUtils$getStarryNetVersionName$2
            r3 = 0
            r1.<init>(r5, r3)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.g(r4, r1, r0)
            if (r4 != r6) goto L_0x0047
            return r6
        L_0x0047:
            java.lang.String r5 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.AppUtils.h(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void i(Context context, String[] strArr, Uri uri, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "packages");
        Intrinsics.checkNotNullParameter(uri, "uri");
        for (String grantUriPermission : strArr) {
            context.grantUriPermission(grantUriPermission, uri, i);
        }
    }

    public final boolean j() {
        return StringsKt.equals("HUAWEI", Build.BRAND, true) || StringsKt.equals("HUAWEI", Build.MANUFACTURER, true);
    }

    public final void k(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            activity.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("AppUtils", "openGpsSetting error: " + e);
            ContextExtKt.e(R.string.fail_to_open, 0, 2, (Object) null);
        }
    }

    public final void m(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        ULog.Delegate delegate = ULog.f6446a;
        String str = Build.MANUFACTURER;
        delegate.a("AppUtils", "openHotspotSetting, MANUFACTURER: " + str);
        if (j()) {
            try {
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$WirelessSettingsActivity"));
                activity.startActivityForResult(intent, i);
            } catch (Exception e) {
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.c("AppUtils", "openHotspotSetting error: " + e);
                ContextExtKt.e(R.string.fail_to_open, 0, 2, (Object) null);
            }
        } else {
            try {
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                activity.startActivityForResult(intent, i);
            } catch (Exception e2) {
                ULog.Delegate delegate3 = ULog.f6446a;
                delegate3.c("AppUtils", "openHotspotSetting error: " + e2);
                ContextExtKt.e(R.string.fail_to_open, 0, 2, (Object) null);
            }
        }
    }

    public final void o(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.addFlags(1);
            context.startActivity(intent);
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("AppUtils", "openInstallPkg error: " + th);
        }
    }

    public final void p(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            activity.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("AppUtils", "openNetworkSetting error: " + e);
            ContextExtKt.e(R.string.fail_to_open, 0, 2, (Object) null);
        }
    }

    public final void r(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
            if (!(context instanceof Activity)) {
                intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("AppUtils", "openStorageSetting error: " + e);
            ContextExtKt.e(R.string.fail_to_open, 0, 2, (Object) null);
        }
    }

    public final void s() {
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_device_connect_history", "null", (Context) null, 4, (Object) null);
        if (!Intrinsics.areEqual((Object) str, (Object) "null")) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("AppUtils", "unbindConnectDevices connect history = " + str);
            StaticMethodUtilsKt.X(str);
        }
        StarryNetApiHandler.m.e();
        VuGlassControlModel.f8109a.D();
    }
}
