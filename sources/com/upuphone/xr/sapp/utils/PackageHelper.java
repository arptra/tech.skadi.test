package com.upuphone.xr.sapp.utils;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.cast.CastConst;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import com.xjmz.myvu.ext.ContextExtKt;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000bJ7\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010$\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010'R\u001a\u0010+\u001a\u00020\u00158\u0006XD¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150,8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150,8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010-¨\u00060"}, d2 = {"Lcom/upuphone/xr/sapp/utils/PackageHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "isFilterSystem", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppInfoModel;", "a", "(Landroid/content/Context;Z)Ljava/util/List;", "e", "Lkotlin/Function1;", "", "call", "Landroid/content/BroadcastReceiver;", "i", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;)Landroid/content/BroadcastReceiver;", "h", "(Landroid/content/Context;)V", "", "packageName", "c", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "b", "(Landroid/content/Context;Ljava/lang/String;)Lcom/upuphone/xr/sapp/monitor/notification/model/AppInfoModel;", "Landroid/content/pm/ActivityInfo;", "info", "Landroid/graphics/drawable/Drawable;", "g", "(Landroid/content/pm/ActivityInfo;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources;", "res", "", "iconId", "f", "(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;", "d", "(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "", "[Ljava/lang/String;", "filterPackage", "whiteListPackage", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPackageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackageHelper.kt\ncom/upuphone/xr/sapp/utils/PackageHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,274:1\n1855#2,2:275\n766#2:278\n857#2,2:279\n1855#2,2:282\n13309#3:277\n13310#3:281\n*S KotlinDebug\n*F\n+ 1 PackageHelper.kt\ncom/upuphone/xr/sapp/utils/PackageHelper\n*L\n56#1:275,2\n89#1:278\n89#1:279,2\n110#1:282,2\n86#1:277\n86#1:281\n*E\n"})
public final class PackageHelper {

    /* renamed from: a  reason: collision with root package name */
    public final String f7905a = "PackageHelper";
    public final String[] b = {"com.upuphone.star.launcher.intl"};
    public final String[] c = {"com.android.mms.service", "com.sec.android.daemonapp", "com.motorola.timeweatherwidget"};

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0088, code lost:
        if ((r0.activityInfo.applicationInfo.flags & 1) != 0) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List a(android.content.Context r20, boolean r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.MAIN"
            r5 = 0
            r0.<init>(r4, r5)
            java.lang.String r4 = "android.intent.category.LAUNCHER"
            r0.addCategory(r4)
            android.content.pm.PackageManager r4 = r20.getPackageManager()
            java.lang.String r5 = "getPackageManager(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r5 = 0
            java.util.List r0 = r4.queryIntentActivities(r0, r5)
            java.lang.String r6 = "queryIntentActivities(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            java.util.Iterator r6 = r0.iterator()
        L_0x0032:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0112
            java.lang.Object r0 = r6.next()
            android.content.pm.ResolveInfo r0 = (android.content.pm.ResolveInfo) r0
            com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel r15 = new com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel
            java.lang.CharSequence r7 = r0.loadLabel(r4)
            java.lang.String r8 = r7.toString()
            android.content.pm.ActivityInfo r7 = r0.activityInfo
            android.content.pm.ApplicationInfo r7 = r7.applicationInfo
            java.lang.String r9 = r7.packageName
            java.lang.String r7 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            android.content.pm.ActivityInfo r7 = r0.activityInfo
            android.content.pm.ApplicationInfo r10 = r7.applicationInfo
            int r10 = r10.uid
            java.lang.String r11 = "activityInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r11)
            android.graphics.drawable.Drawable r11 = r1.g(r7, r2)
            r16 = 112(0x70, float:1.57E-43)
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r7 = r15
            r18 = r15
            r15 = r16
            r16 = r17
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.lang.String[] r7 = r1.b
            java.lang.String r8 = r18.getPackageName()
            boolean r7 = kotlin.collections.ArraysKt.contains((T[]) r7, r8)
            if (r7 == 0) goto L_0x0080
            goto L_0x0032
        L_0x0080:
            android.content.pm.ActivityInfo r0 = r0.activityInfo     // Catch:{ Exception -> 0x008b }
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ Exception -> 0x008b }
            int r0 = r0.flags     // Catch:{ Exception -> 0x008b }
            r7 = 1
            r0 = r0 & r7
            if (r0 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x008b:
            r0 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r8 = r1.f7905a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "getAllAppInfo: Exception "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r7.c(r8, r0)
        L_0x00a4:
            r7 = r5
        L_0x00a5:
            java.lang.String r0 = r18.getPackageName()
            r4.getLaunchIntentForPackage(r0)
            java.lang.String r0 = " "
            java.lang.String r8 = " package:"
            java.lang.String r9 = "getAllAppInfo: add name:"
            if (r21 == 0) goto L_0x00e4
            if (r7 != 0) goto L_0x0032
            r7 = r18
            r3.add(r7)
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r11 = r1.f7905a
            java.lang.String r12 = r7.getName()
            java.lang.String r7 = r7.getPackageName()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r9)
            r13.append(r12)
            r13.append(r8)
            r13.append(r7)
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            r10.g(r11, r0)
            goto L_0x0032
        L_0x00e4:
            r7 = r18
            r3.add(r7)
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r11 = r1.f7905a
            java.lang.String r12 = r7.getName()
            java.lang.String r7 = r7.getPackageName()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r9)
            r13.append(r12)
            r13.append(r8)
            r13.append(r7)
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            r10.g(r11, r0)
            goto L_0x0032
        L_0x0112:
            java.lang.String[] r0 = r1.c
            int r4 = r0.length
        L_0x0115:
            if (r5 >= r4) goto L_0x0153
            r6 = r0[r5]
            com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel r6 = r1.b(r2, r6)
            if (r6 == 0) goto L_0x0150
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r3.iterator()
        L_0x0128:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0147
            java.lang.Object r9 = r8.next()
            r10 = r9
            com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel r10 = (com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel) r10
            java.lang.String r10 = r10.getPackageName()
            java.lang.String r11 = r6.getPackageName()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x0128
            r7.add(r9)
            goto L_0x0128
        L_0x0147:
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0150
            r3.add(r6)
        L_0x0150:
            int r5 = r5 + 1
            goto L_0x0115
        L_0x0153:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.PackageHelper.a(android.content.Context, boolean):java.util.List");
    }

    public final AppInfoModel b(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        PackageManager packageManager = context.getPackageManager();
        try {
            Result.Companion companion = Result.Companion;
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
            Intrinsics.checkNotNullExpressionValue(applicationIcon, "getApplicationIcon(...)");
            return new AppInfoModel(applicationInfo.loadLabel(packageManager).toString(), str, applicationInfo.uid, applicationIcon, false, (String) null, false, 112, (DefaultConstructorMarker) null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    public final String c(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            return packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final Drawable d(Context context) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "getSystem(...)");
        return f(context, system, 17629184);
    }

    public final List e(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<AppInfoModel> a2 = a(context, z);
        ArrayList arrayList = new ArrayList();
        Object systemService = context.getSystemService("appops");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
        AppOpsManager appOpsManager = (AppOpsManager) systemService;
        for (AppInfoModel appInfoModel : a2) {
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Intrinsics.checkNotNull(cls);
                Class cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class});
                Intrinsics.checkNotNullExpressionValue(method, "getMethod(...)");
                Field declaredField = cls.getDeclaredField("OP_POST_NOTIFICATION");
                Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
                Object obj = declaredField.get(cls2);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                Integer num = (Integer) obj;
                num.intValue();
                Object invoke = method.invoke(appOpsManager, new Object[]{num, Integer.valueOf(appInfoModel.getUid()), appInfoModel.getPackageName()});
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) invoke).intValue() == 0) {
                    arrayList.add(appInfoModel);
                } else {
                    ULog.Delegate delegate = ULog.f6446a;
                    String str = this.f7905a;
                    delegate.c(str, "getNotificationPackage No additions:" + appInfoModel);
                }
            } catch (Exception e) {
                arrayList.add(appInfoModel);
                ULog.Delegate delegate2 = ULog.f6446a;
                String str2 = this.f7905a;
                delegate2.c(str2, "getNotificationPackage: Exception " + e);
            }
        }
        return arrayList;
    }

    public final Drawable f(Context context, Resources resources, int i) {
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            Drawable drawableForDensity = resources.getDrawableForDensity(i, ((ActivityManager) systemService).getLauncherLargeIconDensity());
            if (drawableForDensity != null) {
                return drawableForDensity;
            }
        } catch (Exception e) {
            ULog.f6446a.c(this.f7905a, String.valueOf(e.getMessage()));
        }
        return d(context);
    }

    public final Drawable g(ActivityInfo activityInfo, Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        try {
            Resources resourcesForApplication = packageManager.getResourcesForApplication(activityInfo.applicationInfo);
            Intrinsics.checkNotNullExpressionValue(resourcesForApplication, "getResourcesForApplication(...)");
            return f(context, resourcesForApplication, activityInfo.getIconResource());
        } catch (Exception e) {
            ULog.f6446a.c(this.f7905a, String.valueOf(e.getMessage()));
            return d(context);
        }
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (OSHelper.f7904a.g()) {
                Intent intent = new Intent();
                intent.setClassName("com.android.settings", "com.meizu.settings.MzSettingsActivity$FlymeConfigureNotificationSettingsActivity");
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.SETTINGS");
            context.startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
            Intent intent3 = new Intent();
            intent3.setAction("android.settings.SETTINGS");
            context.startActivity(intent3);
        }
    }

    public final BroadcastReceiver i(Context context, boolean z, Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "call");
        ULog.f6446a.g(CastConst.TAG, "packageChange");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        PackageHelper$packageChange$mBroadcastReceiver$1 packageHelper$packageChange$mBroadcastReceiver$1 = new PackageHelper$packageChange$mBroadcastReceiver$1(this, context, z, function1);
        ContextExtKt.a(context, packageHelper$packageChange$mBroadcastReceiver$1, intentFilter);
        return packageHelper$packageChange$mBroadcastReceiver$1;
    }
}
